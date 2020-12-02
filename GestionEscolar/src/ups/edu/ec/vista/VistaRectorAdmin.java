/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorCurso;
import ups.edu.ec.controlador.ControladorDocente;
import ups.edu.ec.modelo.CursoRec;
import ups.edu.ec.modelo.DocenteRec;

/**
 *
 * @author japch
 */
public class VistaRectorAdmin extends javax.swing.JFrame {
    ControladorDocente controladorDocente = new ControladorDocente();
    ControladorCurso controladorCurso = new ControladorCurso();
    DefaultTableModel modeloDocente; 
    DefaultTableModel modeloCurso;
    public static String ruta = "basedatosDocente.obj";
    public static String ruta2 = "basedatosCurso.obj";


    /**
     * Creates new form VistaRectorAdmin
     */
    public VistaRectorAdmin() {
        initComponents();
        CrearModeloDocente();
        CrearModeloCurso();
        
        try {
            controladorDocente.cargarDatos(ruta);
            System.out.println("CARGO DATOS DOCENTE");
        }  catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();   
        }
        modeloDocente = (DefaultTableModel) jTable1.getModel();
        this.listarDatosDocente();
        //this.tablita();
        
        this.jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                cargarDatosDocnete(jTable1.getSelectedRow());
            }
        });
        
        
        
        try {
            controladorCurso.cargarDatos(ruta2);
            System.out.println("CARGO DATOS DOCENTE");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();   
        }
        modeloCurso = (DefaultTableModel) jTable2.getModel();
            this.listarDatosCurso();
            System.out.println("LISTA DATOS");
       this.jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
              cargarDatosCurso(jTable2.getSelectedRow());
            }
        });
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void CrearModeloDocente(){
            try {
                modeloDocente = (new DefaultTableModel (
                null,  new  String []{
                    "Id", "Nombre","Apellido","cedula","Curso"})  {} );
                jTable1.setModel(modeloDocente);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
    }
    
    private void CrearModeloCurso(){
            try {
                modeloCurso = (new DefaultTableModel (
                null,  new  String []{
                    "Id", "Nombre Curso","Nº Alimno"})  {} );
                jTable2.setModel(modeloCurso);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
    }

   public void listarDatosDocente() {
        modeloDocente.setRowCount(0);
        for (DocenteRec p : controladorDocente.getLista()) {
            String datos[] = {String.valueOf(p.getId()),p.getNombreDocente(), p.getApellidoDocente(),p.getCedula(),p.getCurso()};
            modeloDocente.addRow(datos);
        }
    }
   
   
   public void listarDatosCurso() {
        modeloCurso.setRowCount(0);
        for (CursoRec p : controladorCurso.getLista()) {
            String datos[] = {String.valueOf(p.getId()),p.getNombreCurso(),p.getnAlumnos()};
            modeloCurso.addRow(datos);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombredocente = new javax.swing.JTextField();
        txtapellidodocente = new javax.swing.JTextField();
        txtceduladocente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtiddocente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidcurso = new javax.swing.JTextField();
        txtnombrecurso = new javax.swing.JTextField();
        txtnalmunoscurso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtcursodocente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("NUEVO DOCENTE");

        jLabel2.setText("NUEVO CURSO");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        jLabel5.setText("Cedula:");

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("id:");

        jLabel8.setText("id:");

        jLabel6.setText("Nombre curso");

        jLabel9.setText("Nº Alumnos");

        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido", "Cedula", "Curso"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre curso", "Nº Alumnos"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel10.setText("CURSOS");

        jLabel11.setText("DOCENTES");

        jLabel12.setText("Curso:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(txtiddocente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(45, 45, 45))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnombredocente)
                                    .addComponent(txtapellidodocente)
                                    .addComponent(txtceduladocente, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(txtcursodocente)))))
                    .addComponent(jButton1))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombrecurso)
                            .addComponent(txtidcurso)
                            .addComponent(txtnalmunoscurso, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(175, 175, 175))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtiddocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtnombredocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtnombrecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtapellidodocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtnalmunoscurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtceduladocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtcursodocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        verificarcurso();
         listarDatosDocente();
                          

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        tomarDatosCurso();
        listarDatosCurso();
        limpiarcurso();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
        try {
            controladorDocente.guardarDatos(ruta);
        } catch (IOException ex) {
            Logger.getLogger(VistaRectorAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            controladorCurso.guardarDatos(ruta2);
        } catch (IOException ex) {
            Logger.getLogger(VistaRectorAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    
   
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
            java.util.logging.Logger.getLogger(VistaRectorAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRectorAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRectorAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRectorAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRectorAdmin().setVisible(true);
            }
        });
    }
        public void verificarcurso(){
        boolean encontrado=false;
        String namecurso= txtcursodocente.getText();
        
        for (int x = 0; x < controladorCurso.lista.size(); x++) {
        CursoRec p = controladorCurso.lista.get(x);
             if (p.getNombreCurso().equals(namecurso)) {
                 System.out.println();
                     tomarDatosDocente();
                     limpiardocente();
                 encontrado=true;
                break;
               }
           }
        if(encontrado){
            JOptionPane.showMessageDialog(null, "El docente fue asigando con un curso");
 
        }else{
            JOptionPane.showMessageDialog(null, "No existe un curso, crear curso");
            txtcursodocente.setText("");
            
       

        }
   
    }
        public void cargarDatosDocnete(int posicion) {
        if (posicion >= 0) {
            DocenteRec docenteRec = controladorDocente.getLista().get(posicion);
          txtiddocente.setText(docenteRec.getId()+"");
            txtnombredocente.setText(docenteRec.getNombreDocente());
            txtapellidodocente.setText(docenteRec.getApellidoDocente());
            txtceduladocente.setText(docenteRec.getCedula());
            txtcursodocente.setText(docenteRec.getCurso());
            }
        }
    
        public void cargarDatosCurso(int posicion) {
        if (posicion >= 0) {
            CursoRec cursoRec = controladorCurso.getLista().get(posicion);
            txtidcurso.setText(cursoRec.getId()+"");
            txtnombrecurso.setText(cursoRec.getNombreCurso());
            txtnalmunoscurso.setText(cursoRec.getnAlumnos());
            }
        }
        public void limpiardocente(){
            txtiddocente.setText("");
            txtnombredocente.setText("");
            txtapellidodocente.setText("");
            txtceduladocente.setText("");
            txtcursodocente.setText("");
        }
        public void limpiarcurso(){
            txtidcurso.setText("");
            txtnombrecurso.setText("");
            txtnalmunoscurso.setText("");
        }
        public void tomarDatosDocente(){
            System.out.println("Ingreso");
            String iddocente = txtiddocente.getText();
            String nombredocente=txtnombredocente.getText();
            String apellidodocente=txtapellidodocente.getText();
            String ceduladocente=txtceduladocente.getText();
            String cursodocente=txtcursodocente.getText();  
                        if(!iddocente.isEmpty()){
                            if(!nombredocente.isEmpty()){
                                if(!apellidodocente.isEmpty()){
                                    if(!ceduladocente.isEmpty()){
                                        if(!cursodocente.isEmpty()){
                                        DocenteRec p = new DocenteRec(Integer.parseInt(iddocente), nombredocente, apellidodocente, ceduladocente, cursodocente);
                                        controladorDocente.crear(p);
                                        System.out.println("Lista DOcentes: "+controladorDocente.lista);
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                                    }
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                                }
                              
                            }else{
                                JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                            }
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                        }
                    }else{
                            JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                 }
        }
    
        
        
        public void tomarDatosCurso(){
            System.out.println("Entro a tomar datos curso2");
            String idcurso= txtidcurso.getText();
            String nombrecurso= txtnombrecurso.getText();
            String nalumnos=txtnalmunoscurso.getText();
             if(!idcurso.isEmpty()){
                    if(!nombrecurso.isEmpty()){
                            if(!nalumnos.isEmpty()){
                                        CursoRec p = new CursoRec(Integer.parseInt(idcurso), nombrecurso, nalumnos);
                                        controladorCurso.crear(p);
                                        System.out.println("Lista DOcentes: "+controladorCurso.lista);
                            }else{
                                JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                            }     
                    }else{
                          JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                    }      
             }else{
                 JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
         }
    }
        
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtapellidodocente;
    private javax.swing.JTextField txtceduladocente;
    private javax.swing.JTextField txtcursodocente;
    private javax.swing.JTextField txtidcurso;
    private javax.swing.JTextField txtiddocente;
    private javax.swing.JTextField txtnalmunoscurso;
    private javax.swing.JTextField txtnombrecurso;
    private javax.swing.JTextField txtnombredocente;
    // End of variables declaration//GEN-END:variables
}
