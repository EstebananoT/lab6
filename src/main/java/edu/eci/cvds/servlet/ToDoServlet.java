package edu.eci.cvds.servlet;
import edu.eci.cvds.servlet.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@WebServlet(
        urlPatterns = "/todoServlet"
)

public class ToDoServlet extends HttpServlet {
    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
            if (optName.isPresent()) {
                int id = Integer.parseInt(optName.get());
                resp.setStatus(HttpServletResponse.SC_OK);
                ArrayList<Todo> todos = new ArrayList<>();
                Todo todo = Service.getTodo(id);
                todos.add(todo);
                responseWriter.write(Service.todosToHTMLTable(todos));
            }
        }
        catch (FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("No existe un item con el identificador dado");
        }
        catch (NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseWriter.write("El parametro no es un numero");
        }
        catch (MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseWriter.write("Error interno del servidor");
        }
        catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseWriter.write("Requerimiento invalido");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
            if (optName.isPresent()) {
                int id = Integer.parseInt(optName.get());
                resp.setStatus(HttpServletResponse.SC_OK);
                ArrayList<Todo> todos = new ArrayList<>();
                Todo todo = Service.getTodo(id);
                todos.add(todo);
                responseWriter.write(Service.todosToHTMLTable(todos));
            }
        }
        catch (FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("No existe un item con el identificador dado");
        }
        catch (NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseWriter.write("El parametro no es un numero");
        }
        catch (MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseWriter.write("Error interno del servidor");
        }
        catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseWriter.write("Requerimiento invalido");
        }
    }
}
