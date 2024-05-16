package Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Beans.user;
import DAO.UserDao;

@WebServlet("/AjouterUtilisateur")
@MultipartConfig 
public class AjouterUtilisateur extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao dao = new UserDao();

    public AjouterUtilisateur() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        this.getServletContext().getRequestDispatcher( "/WEB-INF/AjouterUser.jsp" ).forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");

        Part filePart = request.getPart("image");
        InputStream fileContent = filePart.getInputStream();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = fileContent.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = outputStream.toByteArray();

        user user = new user(name, prenom, email, mdp);
        user.setImage(imageBytes); 

        dao.addUser(user);
        response.sendRedirect("AllUsers");
    }
    

}
