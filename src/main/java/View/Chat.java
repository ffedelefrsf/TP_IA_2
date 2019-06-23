/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import Memorias.Trabajo;
import Model.Notebook;
import Model.Smartphone;
import Model.Tablet;
import Model.Tv;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author faust
 */
public class Chat extends javax.swing.JFrame {

    /**
     * Creates new form Chat
     */
    private boolean flagUser = false, flagUso = false, flagProducto = false, flagEmpleado = false;
    private final ProductController pc= new ProductController();
    private final Color COLOR_CADE = Color.RED;
    private final Color COLOR_USER = Color.BLUE;
    
    public Chat() {
        initComponents();
        addText("Se ha iniciado el chat con Cade Agent\n\n---------------------------------------------------------------------------------------------------------------------------\n\n", Color.BLACK);
//        chatPanel.setPreferredSize(new Dimension(1000, 1000));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textField = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatPanel = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        textField.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldKeyTyped(evt);
            }
        });

        button.setText("Send");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        chatPanel.setEditable(false);
        chatPanel.setFocusable(false);
        jScrollPane2.setViewportView(chatPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        if (!textField.getText().isEmpty()){
            addText("Usuario dice:\n"+textField.getText()+"\n\n", COLOR_USER);
            TokenProcessing tp = new TokenProcessing(textField.getText());
            textField.setText(null);
            WordController wc= new WordController();
            
            List<String> inputStringAux= tp.tokenize();
            List<String> inputString= new ArrayList<>();
                    
            for(String s: inputStringAux){
                try {
                    String w = wc.getKey(s);
                    if(w.isEmpty()){
                        inputString.add(s);
                    }
                    else{
                        inputString.add(w);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            Analizar analyze = new Analizar(inputString);
            
//            for (String componente : Trabajo.getInstance().getComponentes()){
//                    if (componente.equals("Empleado") && componente.equals("Cliente")){
//                        flag = true;
//                    }
//            }
            List<String> componentes = Trabajo.getInstance().getComponentes();

            if (componentes.contains("noempleado") && componentes.contains("nocliente")){
                if (flagUser)
                    addText("CadeAgent dice:\nNo comprendo. Eres un cliente o un empleado?\n\n", COLOR_CADE);
                else
                    addText("CadeAgent dice:\nEres un cliente o un empleado?\n\n", COLOR_CADE);
                flagUser = true;
            }else if (!componentes.contains("noproducto") && componentes.contains("nouso")){
                if (flagUso){
                    if(componentes.contains("notebook"))
                                addText("CadeAgent dice:\nLo siento, no comprendo el uso que le dará. ¿La usará para jugar o para trabajar?\n\n", COLOR_CADE);
                    if(componentes.contains("smart tv"))
                                addText("CadeAgent dice:\nLo siento, no comprendo el uso que le dará. ¿Lo dará uso normal o pretende visión de calidad?\n\n", COLOR_CADE);
                    if(componentes.contains("smartphone"))
                                addText("CadeAgent dice:\nLo siento, no comprendo el uso que le dará. ¿Le interesa la fotografía o uso regular?\n\n", COLOR_CADE);
                    if(componentes.contains("tablet"))
                                addText("CadeAgent dice:\nLo siento, no comprendo el uso que le dará. ¿La usará para jugar o para trabajar? ¿Quiere algo económico o que tenga buena cámara?\n\n", COLOR_CADE);
                }else{
                    if(componentes.contains("notebook"))
                                addText("CadeAgent dice:\n¿Para qué la va a utilizar?\n\n", COLOR_CADE);
                    if(componentes.contains("smart tv"))
                                addText("CadeAgent dice:\n¿Para qué lo va a utilizar?\n\n", COLOR_CADE);
                    if(componentes.contains("smartphone"))
                                addText("CadeAgent dice:\n¿Para qué lo va a utilizar?\n\n", COLOR_CADE);
                    if(componentes.contains("tablet"))
                                addText("CadeAgent dice:\n¿Para qué la va a utilizar?\n\n", COLOR_CADE);
                }
                flagUso = true;
            }else if (componentes.contains("producto") && !componentes.contains("nouso")){
//                boolean disponibilidad = false;
                String productos = "";
                for (String word: componentes){
                    if (word.equals("HP ELITE A9") || word.equals("DELL INSPIRON 3585") || word.equals("LENOVO V330") || word.equals("HP OMEN 35000") || 
                            word.equals("ASUS VIVOBOOK E406") || word.equals("ASUS FX504") || word.equals("DELL ALIENWARE 17") || word.equals("ACER ASPIRE 3") || 
                            word.equals("ACER PREDATOR HELIOS 300") || word.equals("LG 43LK5700") || word.equals("LG 32LJ600B") || word.equals("SAMSUNG UN49K5500") || 
                            word.equals("SAMSUNG J4300") || word.equals("NOBLEX EA43X5100") || word.equals("NOBLEX DI49X6500") || word.equals("TCL L32S6500") || 
                            word.equals("TCL L49S62") || word.equals("PHILIPS 55OLED873") || word.equals("PHILIPS 32PHG5102") || word.equals("XIAOMI MI 8 PRO") || 
                            word.equals("XIAOMI REDMI NOTE 7") || word.equals("SAMSUNG GALAXY NOTE 9 ") || word.equals("SAMSUNG GALAXY A50") || word.equals("ONEPLUS 6T") || 
                            word.equals("ONEPLUS 7 PRO") || word.equals("HUAWEI MATE 20 PRO") || word.equals("HUAWEI P20 LITE") || word.equals("MOTO G7 PLUS") || 
                            word.equals("MOTO E5 PLUS") || word.equals("SAMSUNG SM-T560") || word.equals("SAMSUNG SM-T580") || word.equals("GADNIC TAB038BK") || 
                            word.equals("GADNIC FENIX PHONE") || word.equals("LENOVO TB3-710F") || word.equals("LENOVO YOGA TAB 3") || word.equals("IPAD PRO") || 
                            word.equals("IPAD 2") || word.equals("HUAWEI BG2-W09") || word.equals("HUAWEI T3 10")){
//                        disponibilidad = true;
                        productos = productos.concat("\t■ "+word+"\n");
                    }
                }
                String salida;
//                if (disponibilidad){
                    salida = "CadeAgent dice:\nLos productos disponibles son:\n"+productos+"\n";
//                }else{
//                    salida = "Lo siento, no conozco ese producto.";
//                }
                addText(salida, COLOR_CADE);
                if (componentes.contains("cliente")){
                    Trabajo.getInstance().reset("cliente");
                    addText("¿Qué otro producto le interesa?\n\n", COLOR_CADE);
                }else{
                    Trabajo.getInstance().reset("empleado");
                    addText("CadeAgent dice:\n¿Desea información sobre un producto en especial o disponibilidad de productos?\n\n", COLOR_CADE);
                    flagProducto = false;
                }
                flagUso = false;
            }
            else{
                if (componentes.contains("empleado") && componentes.contains("noproducto") && componentes.contains("nocaracteristica") && !componentes.contains("disponibilidad")){
                    if (flagEmpleado){
                        addText("CadeAgent dice:\nLo siento, no cuento con esa opción. Puede elegir entre una característica o disponibilidad de productos.\n"
                            + "¿Desea información sobre un producto en especial o disponibilidad de productos?\n\n", COLOR_CADE);
                    }else{
                        addText("CadeAgent dice:\n¿Desea información sobre un producto en especial o disponibilidad de productos?\n\n", COLOR_CADE);
                        flagEmpleado = true;
                    }
                }else{
                    if (componentes.contains("empleado") && componentes.contains("caracteristica") && componentes.contains("consulta")){
                        String productos = "";
                        for (String word: componentes){
//                            if (word.equals("HP ELITE A9") || word.equals("DELL INSPIRON 3585") || word.equals("LENOVO V330") || word.equals("HP OMEN 35000") || 
//                                    word.equals("ASUS VIVOBOOK E406") || word.equals("ASUS FX504") || word.equals("DELL ALIENWARE 17") || word.equals("ACER ASPIRE 3") || 
//                                    word.equals("ACER PREDATOR HELIOS 300") || word.equals("LG 43LK5700") || word.equals("LG 32LJ600B") || word.equals("SAMSUNG UN49K5500") || 
//                                    word.equals("SAMSUNG J4300") || word.equals("NOBLEX EA43X5100") || word.equals("NOBLEX DI49X6500") || word.equals("TCL L32S6500") || 
//                                    word.equals("TCL L49S62") || word.equals("PHILIPS 55OLED873") || word.equals("PHILIPS 32PHG5102") || word.equals("XIAOMI MI 8 PRO") || 
//                                    word.equals("XIAOMI REDMI NOTE 7") || word.equals("SAMSUNG GALAXY NOTE 9") || word.equals("SAMSUNG GALAXY A50") || word.equals("ONEPLUS 6T") || 
//                                    word.equals("ONEPLUS 7 PRO") || word.equals("HUAWEI MATE 20 PRO") || word.equals("HUAWEI P20 LITE") || word.equals("MOTO G7 PLUS") || 
//                                    word.equals("MOTO E5 PLUS") || word.equals("SAMSUNG SM-T560") || word.equals("SAMSUNG SM-T580") || word.equals("GADNIC TAB038BK") || 
//                                    word.equals("GADNIC FENIX PHONE") || word.equals("LENOVO TB3-710F") || word.equals("LENOVO YOGA TAB 3") || word.equals("IPAD PRO") || 
//                                    word.equals("IPAD 2") || word.equals("HUAWEI BG2-W09") || word.equals("HUAWEI T3 10")){
        //                        disponibilidad = true;
                                if(pc.getNotebook(word)!=null){
                                    
                                    productos = productos.concat(pc.getNotebook(word).toString());
                                    
                                }
                                else{
                                    if(pc.getSmartphone(word)!=null){
                                        productos = productos.concat(pc.getSmartphone(word).toString());
                                    }
                                    else{
                                        if(pc.getTv(word)!=null){
                                            productos = productos.concat(pc.getTv(word).toString());
                                        }
                                        else{
                                            if(pc.getTablet(word)!=null){
                                                productos = productos.concat(pc.getTablet(word).toString());
                                            }
                                        }
                                    }
                                }
//                                productos = productos.concat("\t■ "+word+"\n");
//                            }
                            
                        }
                        String salida;
        //                if (disponibilidad){
                            salida = "CadeAgent dice:\nLas características son:\n"+productos+"\n";
        //                }else{
        //                    salida = "Lo siento, no conozco ese producto.";
        //                }
                        addText(salida, COLOR_CADE);
                        if (componentes.contains("cliente")){
                            Trabajo.getInstance().reset("cliente");
                            addText("¿Qué otro producto le interesa?\n\n", COLOR_CADE);
                        }else{
                            Trabajo.getInstance().reset("empleado");
                            addText("CadeAgent dice:\n¿Desea información sobre un producto en especial o disponibilidad de productos?\n\n", COLOR_CADE);
                        }
                        flagUso = false;
                        flagProducto = false;
                    }else{
                        if (!componentes.contains("producto")){
                            if (componentes.contains("caracteristica")){
                                if (flagProducto){
                                    String output = "CadeAgent dice:\nLo siento, no conozco ese producto. Los productos disponibles son los siguientes:\n";
                                    output = output.concat("\tNotebooks:\n");
                                    for (Notebook note : pc.getNotebooks()){
                                        output = output.concat("\t\t■ "+note.getModelo()+"\n");
                                    }
                                    output = output.concat("\tTablets:\n");
                                    for (Tablet tab : pc.getTablets()){
                                        output = output.concat("\t\t■ "+tab.getModelo()+"\n");
                                    }
                                    output = output.concat("\tSmart TVs:\n");
                                    for (Tv tele : pc.getTvs()){
                                        output = output.concat("\t\t■ "+tele.getModelo()+"\n");
                                    }
                                    output = output.concat("\tSmartphones:\n");
                                    for (Smartphone celu : pc.getSmartphones()){
                                        output = output.concat("\t\t■ "+celu.getModelo()+"\n");
                                    }
                                    output = output.concat("¿Qué producto le interesa?\n\n");
                                    addText(output, COLOR_CADE);
                                }else{
                                    addText("CadeAgent dice:\n¿Las características de qué producto desea saber?\n\n", COLOR_CADE);
                                }
                                flagProducto = true;
                            }else{
                                if (flagProducto)
                                    addText("CadeAgent dice:\nLo siento, no conozco ese producto. Puede elegir entre notebook, tablet, smart tv o smartphone.\n"
                                            + "¿Qué producto le interesa?\n\n", COLOR_CADE);
                                else{
                                    addText("CadeAgent dice:\n¿Qué producto le interesa?\n\n", COLOR_CADE);
                                }
                                flagProducto = true;
                            }
                        }
                    }
                }
            }
//            else{
//                if(!componentes.contains("característica")){
//                    addText("CadeAgent dice:\n¿Alguna característica especial?\n\n", COLOR_CADE);
//                }
//                else{
//                   addText("CadeAgent dice:\nNo comprendo.\n\n", COLOR_CADE);
//                }
//            }
            
            System.out.println("-----------------------------------------------------------");
            System.out.println("MEMORIA DE TRABAJO");
            System.out.println("-----------------------------------------------------------");
            for (String componente : Trabajo.getInstance().getComponentes()){
                System.out.println(componente);
            }
            System.out.println("-----------------------------------------------------------");
//            addText("CadeAgent dice:\nno te entiendo\n\n", COLOR_CADE);
        }
    }//GEN-LAST:event_buttonActionPerformed

    private void textFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldKeyTyped
        if (evt.getKeyChar()==KeyEvent.VK_ENTER){
            button.doClick();
        }
    }//GEN-LAST:event_textFieldKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat().setVisible(true);
//                System.out.println("-----------------------------------------------------------");
//                System.out.println("MEMORIA DE TRABAJO");
//                System.out.println("-----------------------------------------------------------");
//                for (String componente : Trabajo.getInstance().getComponentes()){
//                    System.out.println(componente);
//                }
//                System.out.println("-----------------------------------------------------------");
            }
        });
    }
    
    private void addText(String text, Color color){
        StyledDocument doc = chatPanel.getStyledDocument();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        int len = doc.getLength();
        chatPanel.setCaretPosition(len);
        chatPanel.setCharacterAttributes(aset, false);
        
        try {
            doc.insertString(len, text, aset);
        } 
        catch (BadLocationException e) {
            e.printStackTrace();
        }
        pack();
        this.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.JTextPane chatPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}
