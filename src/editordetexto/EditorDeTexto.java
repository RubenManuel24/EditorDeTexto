
package editordetexto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author RubenManuel
 */
public class EditorDeTexto extends JFrame implements ActionListener {
   JTextArea texto;
    public EditorDeTexto(){
     super("Editor");
     
     JButton botao = new JButton("ESCOLHER ARQUIVO");
     texto = new JTextArea();
     JScrollPane scroll= new JScrollPane(texto);
     texto.setFont(new Font("fonte", Font.PLAIN,20));
     texto.setForeground(Color.BLACK);
     texto.setBackground(Color.white);
     
     
     Container c = getContentPane();
     c.setLayout(new BorderLayout());
     c.add(BorderLayout.CENTER, scroll);
     c.add(BorderLayout.SOUTH, botao);
     
     botao.addActionListener(this);
     
     setVisible(true);
     setSize(500,500);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        JFileChooser ch = new JFileChooser();
        ch.showOpenDialog(this);
        
        File file = ch.getSelectedFile();

        Path path = Paths.get(file.getAbsolutePath());
        
        try {
            
            String retorno = new String(Files.readAllBytes(path)) ;
            texto.setText(retorno);
            
            
        } 
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO");
        }
        
    }
   
  
  
  
  }

    
    