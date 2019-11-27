package br.com.fiap.healthtrack.servlets;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.fiap.healthtrack.Usuario;
import br.com.fiap.healthtrack.dao.UsuarioDAO;


@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	
	public void init() {
		usuarioDAO = new UsuarioDAO();
	}    
    public UsuarioServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dsEmail = request.getParameter("dsEmail");
		String nmUsuario = request.getParameter("nmUsuario");
		String dsSenha = request.getParameter("dsSenha");
		String dtNascimento = request.getParameter("dtNascimento");
		String dsSexo = request.getParameter("dsSexo");
		String vlAltura = request.getParameter("vlAltura");
		
		Usuario usuario = new Usuario();
		usuario.setDsEmail(dsEmail);
		usuario.setNmUsuario(nmUsuario);
		usuario.setDsSenha(dsSenha);
		usuario.setDtNascimento(dtNascimento);
		usuario.setDsSexo(dsSexo);
		usuario.setVlAltura(vlAltura);
		
		  try {
	            usuarioDAO.insert(usuario);
	        } 
		  catch (Exception e) {
	            e.printStackTrace();
	        }

	        response.sendRedirect("./dashboard.jsp");
	    }
	}

}
