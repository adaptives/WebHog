package com.diycomputerscience.webhog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CPUHogServlet
 */
@WebServlet("/CPUHogServlet")
public class CPUHogServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String LONG_LIVING_OBJECTS = "LongLivingObjects";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CPUHogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String runAsThreaded = request.getParameter("threading");
		
		CPUHogData cpuHogData = null;
		
		if(runAsThreaded != null && runAsThreaded.equalsIgnoreCase("true")) {
			runAsThreaded();
			//forward to the results page
			request.setAttribute("result", "running cpuhog in threaded mode");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} else {
			String sCount1 = request.getParameter("count1");
			String sCount2 = request.getParameter("count2");
			String sSysout = request.getParameter("sysout");
			
			int count1 = Integer.parseInt(sCount1);
			int count2 = Integer.parseInt(sCount2);
			boolean sysout = false;
			if(sSysout != null && sSysout.equals("true")) {
				sysout = true;
			}
			cpuHogData = consumeCPU(count1, count2, sysout);
			//forward to the results page
			request.setAttribute("result", cpuHogData.toString());
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}
	
	private CPUHogData consumeCPU(int count1, int count2, boolean sysout) {
		SomeSillyDataAnalyser dataAnalyser = new SomeSillyDataAnalyser(count1, count2, sysout);
		return dataAnalyser.analyse();
	}

	private void runAsThreaded() {
		LoopingThreads loopingThreads = new LoopingThreads();
		loopingThreads.loopEm();
	}

}
