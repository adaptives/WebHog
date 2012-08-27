package com.diycomputerscience.webhog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemoryHogServlet
 */
@WebServlet("/MemoryHogServlet")
public class MemoryHogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LONG_LIVING_OBJECTS = "LongLivingObjects";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemoryHogServlet() {
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
		System.out.println("Entering doPost real free mem " + (Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()))/(1024*1024));

		String sLongLivingObjects = request.getParameter("llo");
		String sIterations = request.getParameter("iterations");
		String sObjects = request.getParameter("objects");
		int longLivingObjects = Integer.parseInt(sLongLivingObjects);
		int iterations = Integer.parseInt(sIterations);
		int objects = Integer.parseInt(sObjects);
		
		adjustLongLivingObjects(longLivingObjects);
		
		WidgetFactory widgetFactory = new SimpleWidgetFactory(iterations, objects);
		widgetFactory.startFactory();
		
		request.setAttribute("result", "This test took " + widgetFactory.timeTaken() + "ms");
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		System.out.println("Exiting doPost real free mem " + (Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()))/(1024*1024));
	}
	
	private void adjustLongLivingObjects(int expectedLongLivingObjects) {
		List<Widget> longLivingWidgets = 
				(List<Widget>)this.getServletContext().getAttribute(LONG_LIVING_OBJECTS);
		if(longLivingWidgets == null) {
			longLivingWidgets = new ArrayList<Widget>();
			this.getServletContext().setAttribute(LONG_LIVING_OBJECTS, longLivingWidgets);
		}
		int currentLLOSize = longLivingWidgets.size(); 
		if(currentLLOSize < expectedLongLivingObjects) {
			for(int i=0; i<(expectedLongLivingObjects-currentLLOSize); i++) {
				longLivingWidgets.add(new Widget());
			}
		} else if(currentLLOSize > expectedLongLivingObjects) {
			for(int i=0; i<(currentLLOSize-expectedLongLivingObjects); i++) {
				longLivingWidgets.remove(0);
			}
		}
	}

}
