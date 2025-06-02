/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 *
 * @author Paulo
 * 
 * Class responsavel por chamar os dados do ENV, para sincronizar o Banco de Dados
 * 
 */
package br.com.prsoftware.env;

import jakarta.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class EnvLoader {
    private static final Properties props = new Properties();

    public static void load(ServletContext context) {
        try {
            String fullPath = context.getRealPath("/WEB-INF/.env");
            InputStream input = new FileInputStream(fullPath);
            props.load(input);
            input.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar .env: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
