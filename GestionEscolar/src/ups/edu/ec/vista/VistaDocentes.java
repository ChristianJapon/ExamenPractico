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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableModel;
import ups.edu.ec.controlador.ControladorAlumno;
import ups.edu.ec.controlador.ControladorCurso;
import ups.edu.ec.modelo.Alumno;
import ups.edu.ec.modelo.CursoRec;

/**
 *
 * @author japch
 */
public class VistaDocentes extends javax.swing.JFrame {
    ControladorAlumno controladorAlumno= new ControladorAlumno();
    ControladorCurso controladorCurso = new ControladorCurso();
    DefaultTableModel modeloAlumno; 
    public static String ruta = "basedatosAlumno.obj";
    public static String ruta2 = "basedatosCurso.obj";
    /**
     * Creates new form VistaDocentes
     */
    public VistaDocentes() {
 
       initComponents();
       CrearModeloAlumno();
        try {
            controladorAlumno.cargarDatos(ruta);
        } catch (IOException ex) {
            Logger.getLogger(VistaDocentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaDocentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            controladorCurso.cargarDatos(ruta2);
        }catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
         }
            modeloAlumno = (DefaultTableModel) jTable1.getModel();
            this.listarDatos();
            this.jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           @Override
           public void valueChanged(ListSelectionEvent lse) {
               cargarDatosAlumno(jTable1.getSelectedRow());
           }
       });
        
        
        
    }
       public void cargarDatosAlumno(int posicion) {
        if (posicion >= 0) {
            Alumno al = controladorAlumno.getLista().get(posicion);
            txtidestudiante.setText(al.getId()+"");
            txtnombreEstudiante.setText(al.getNombreestudainte());
            txtcursoestudiante.setText(al.getCurso());
            txtactividad.setText(al.getActividad());
            }
        }
      public void listarDatos() {
        modeloAlumno.setRowCount(0);
        for (Alumno matr : controladorAlumno.getLista()) {
            String datos[] = {String.valueOf(matr.getId()),matr.getNombreestudainte(),matr.getCurso(), matr.getActividad()};
            modeloAlumno.addRow(datos);
        }
    }   

      private void CrearModeloAlumno(){
          System.out.println("Entra a crear");
            try {
                modeloAlumno = (new DefaultTableModel (
                null,  new  String []{
                    "Id Estudiante", "Nombre Estudiante","Curso","Actividad"})  {} );
                jTable1.setModel(modeloAlumno);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
    }
      
     public void verificarcurso(){
        boolean encontrado=false;
        String curso= txtcursoestudiante.getText();
        
        for (int x = 0; x < controladorCurso.lista.size(); x++) {
        CursoRec p = controladorCurso.lista.get(x);
             if (p.getNombreCurso().equals(curso)) {
                //----------COLOCAR TOMAR DATOS
                tomarDatos();
                limpiar();
                 encontrado=true;
                break;
               }
           }
        if(encontrado){
            JOptionPane.showMessageDialog(null, "El CURSO existe");
        }else{
            JOptionPane.showMessageDialog(null, "El curso no existe, el recor debe crear un curso");
            txtcursoestudiante.setText("");
        }
   
    }
     
    public void tomarDatos(){
         String id= txtidestudiante.getText();
         String nombre= txtnombreEstudiante.getText();
         String curso= txtcursoestudiante.getText();
         String actividad=txtactividad.getText();if(!id.isEmpty()){
                   if(!nombre.isEmpty()){
                        if(!curso.isEmpty()){
                            if(!actividad.isEmpty()){
                                Alumno al = new Alumno(Integer.parseInt(id), nombre, curso, actividad);
                                controladorAlumno.crear(al);
                                System.out.println("Lista Alumnos: "+controladorAlumno.lista);
                                
                                         }else{
                                        JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                                    }}else{
                                    JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                                } }else{
                                JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Revisar!! un camo se encientra vacio");
                        }
    } 
    
    public void limpiar(){
        txtidestudiante.setText("");
        txtnombreEstudiante.setText("");
        txtactividad.setText("");
        txtcursoestudiante.setText("");
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtcursoestudiante = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtidestudiante = new javax.swing.JTextField();
        txtnombreEstudiante = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtactividad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Curso");

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Estudiante");

        jLabel3.setText("Id:");

        jLabel4.setText("Actividad Asignada");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id estudiante", "Nombre Estudiante", "Curso", "Actividad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcursoestudiante)
                            .addComponent(txtnombreEstudiante)
                            .addComponent(txtidestudiante, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtactividad, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtidestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtcursoestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtactividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        verificarcurso();
          listarDatos();
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

                  try {
            controladorAlumno.guardarDatos(ruta);
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());
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
            java.util.logging.Logger.getLogger(VistaDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaDocentes().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtactividad;
    private javax.swing.JTextField txtcursoestudiante;
    private javax.swing.JTextField txtidestudiante;
    private javax.swing.JTextField txtnombreEstudiante;
    // End of variables declaration//GEN-END:variables
}
