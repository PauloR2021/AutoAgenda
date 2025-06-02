/**
 *
 * @author Paulo
 * 
 * Servlet responsavel por localizar o arquivo .env
 */

package br.com.prsoftware.servlet;

import br.com.prsoftware.env.EnvLoader;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;



@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EnvLoader.load(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Pode deixar vazio
    }
}
