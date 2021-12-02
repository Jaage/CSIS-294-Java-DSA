package com.dronerecon.ws;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import java.io.*;
        import java.util.*;
        import java.security.SecureRandom;

/**
 *
 * @author JJ Hubbard
 */
public class DroneDataService extends HttpServlet{


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

        // ##############################
        // 1. Get params passed in.

        // Get the following parameters from the request object and put them into strings:
        // area_id
        // tilex
        // tiley
        // totalcols
        // totalrows
        // ##############################

        String area_id = request.getParameter("area_id");
        String tileX = request.getParameter("tilex");
        String tileY = request.getParameter("tiley");
        String totalCols = request.getParameter("totalcols");
        String totalRows = request.getParameter("totalrows");



        // ##############################
        // 2. Default value of beginning direction.

        // Set a string called sDirection to "right".
        // ##############################

        String sDirection = "right";


        // ##############################
        // 3. Calculate next drone move.

        // Determine next tile to move to.
        // Base this on current x and y.
        // Change sDirection if necessary.
        // Drone must serpentine from top left of grid back and forth down.
        // If rows are done, change sDirection to "stop".
        // ##############################


        // This is kind of pseudo code for when we are in the last row
        // I couldn't find anything that gave a good description of area_id
        // So I assumed that tileX and tileY are the X and Y coordinates that the drone just sent
        // Since you said to store these variables as strings I was not sure if I should convert
        // them to ints or not. So I left it in this weird format haha.
        if (totalRows is even && tileY.equals("0") && sDirection.equals("left")) {
            sDirection = "stop"
        } else if (totalRows is odd && tileY.equals(totalRows) && sDirection.equals("right") {
            sDirection = "stop";

        } else {
            if (sDirection.equals("right")) {
                if (tileX.equals(totalCols)) { // might need to -1 if grid starts at 0
                    tileY++;
                    sDirection = "left";
                } else {
                    tileX++;
                }
            } else {
                if (tileX.equals("0")) {
                    tileY++;
                    sDirection = "right";
                } else {
                    tileX--;
                }
            }
        }
        

        // ##############################
        // 4. Format & Return JSON string to caller.

        /* Return via out.println() a JSON string like this:
        {"area_id":"[area id from above]", "nextTileX":"[next tile x]", "nextTileY":"[next tile y]", "direction":"[direction string from above]"}
        */
        // ##############################

    }
}

