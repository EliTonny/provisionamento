/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package provisionamento.view;

import MyExceptions.DaoException;
import Sistema.Dao;
import Sistema.Factoring;
import Sistema.Session;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import provisionamento.model.Categoria;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Participante;
import provisionamento.model.Usuario;

/**
 *
 * @author Lucas
 */
public class FrameGrupoComunitario extends javax.swing.JFrame {

    /**
     * Creates new form FrameGrupoComunitario
     */
    public FrameGrupoComunitario() {
        initComponents();
        tfCriador.setText(Session.getInstancia().getUsuarioLogado().getNome());
        cbCategoria.removeAllItems();
        lsParticipantesGrupo.setModel(listaParticipantes);
        try {
            Dao<Categoria> daoCat = Factoring.getDaoCategoria();
            List<Categoria> categorias = daoCat.busca();
            Iterator it = categorias.iterator();
            
            while(it.hasNext()){
                cbCategoria.addItem((Categoria) it.next());
            }
            
            Dao<Usuario> daoUsu = Factoring.getDaoUsuario();
            List<Usuario> usuarios = daoUsu.busca();
            it = usuarios.iterator();
            while(it.hasNext()){
                listaUsuarios.addElement((Usuario) it.next());
            }
            
            listaUsuarios.removeElement(Session.getInstancia().getUsuarioLogado());
            lsMembrosRepublica.setModel(listaUsuarios);
            
        } catch (DaoException ex) {
            Logger.getLogger(FrameGrupoComunitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private FrameCategoria frameCategoria;
    private DefaultListModel<Usuario> listaParticipantes = new DefaultListModel<>();
    private DefaultListModel<Usuario> listaUsuarios  = new DefaultListModel();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        btAddCategoria = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfQtdItens = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfDataVencimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCriador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btPraCa = new javax.swing.JButton();
        btPraLa = new javax.swing.JButton();
        btAddGrupoComun = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsMembrosRepublica = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lsParticipantesGrupo = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        tfQtdDias = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Novo Grupo Comunitário");

        jLabel2.setText("Categoria:");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btAddCategoria.setText("+");
        btAddCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Criador:");

        jLabel4.setText("Quantidade:");

        jLabel6.setText("Vencimento:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Quantos dias faltam para o vencimento do grupo.");

        tfCriador.setEnabled(false);

        jLabel7.setText("Membros da República");

        jLabel8.setText("Participantes do Grupo");

        btPraCa.setText("<<");
        btPraCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPraCaActionPerformed(evt);
            }
        });

        btPraLa.setText(">>");
        btPraLa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPraLaActionPerformed(evt);
            }
        });

        btAddGrupoComun.setText("Adicionar Grupo");
        btAddGrupoComun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddGrupoComunActionPerformed(evt);
            }
        });

        lsMembrosRepublica.setPreferredSize(new java.awt.Dimension(135, 210));
        jScrollPane3.setViewportView(lsMembrosRepublica);

        jScrollPane4.setViewportView(lsParticipantesGrupo);

        jLabel9.setText("dias antes do vencimento.");

        jLabel10.setText("Notificar:");

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btPraLa, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btPraCa, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btAddGrupoComun)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(65, 65, 65)))
                            .addComponent(btFechar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfQtdItens, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btAddCategoria))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel3))
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfCriador)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(tfQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel9)
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(247, 247, 247))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(jLabel1)))
                        .addGap(0, 42, 42)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btAddCategoria)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQtdItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCriador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(btPraLa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btPraCa))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAddGrupoComun)
                    .addComponent(btFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btAddCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddCategoriaActionPerformed
        frameCategoria = new FrameCategoria();
        frameCategoria.setVisible(true);
    }//GEN-LAST:event_btAddCategoriaActionPerformed

    private void btPraLaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPraLaActionPerformed
        List<Usuario> usariosSelecionados = lsMembrosRepublica.getSelectedValuesList();
        Iterator itUsuSel = usariosSelecionados.iterator();
        Usuario usuario;
        while(itUsuSel.hasNext()){
            usuario = (Usuario) itUsuSel.next();            
            listaParticipantes.addElement(usuario);
            listaUsuarios.removeElement(usuario);
        }
    }//GEN-LAST:event_btPraLaActionPerformed

    private void btPraCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPraCaActionPerformed
        List<Usuario> participantesSelecionados = lsParticipantesGrupo.getSelectedValuesList();
        Iterator itParSel = participantesSelecionados.iterator();
        Usuario usuario;
        while(itParSel.hasNext()){
            usuario = (Usuario) itParSel.next();            
            listaUsuarios.addElement(usuario);
            listaParticipantes.removeElement(usuario);
        }
    }//GEN-LAST:event_btPraCaActionPerformed

    private void btAddGrupoComunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddGrupoComunActionPerformed
        boolean ok = true;
        int qtdItens = 0;
        int qtdVencimento = 0;
        int qtdAntecip = 0;
        Date prazo = new Date();
        Participante participante;
        
        if(tfQtdItens.getText().equals("")){
            ok = false;
            JOptionPane.showMessageDialog(null, "Quantidade de itens não informada!");
        }
        try{
            qtdItens = Integer.parseInt(tfQtdItens.getText());
        } catch(NumberFormatException ex){
            ok = false;
            JOptionPane.showMessageDialog(null, "Quantidade de itens deve ser um número!");
        }
        
        if(tfDataVencimento.getText().equals("")){
            ok = false;
            JOptionPane.showMessageDialog(null, "Prazo de vencimento não informado!");
        }
        try{
            qtdVencimento = Integer.parseInt(tfDataVencimento.getText());
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Prazo de vencimento deve ser um número!");
        }
        
        if(tfQtdDias.getText().equals("")){
            qtdAntecip = 0;
        } else{
            try{
                qtdAntecip = Integer.parseInt(tfQtdDias.getText());
            } catch(NumberFormatException ex){
                ok = false;
                JOptionPane.showMessageDialog(null, "Dias para notificar deve ser um número!");
            }
        }
        
        if(listaParticipantes.isEmpty()){
            ok = false;
            JOptionPane.showMessageDialog(null, "Lista de participantes deve conter ao menous um participante!");
        }
        
        if(ok == true){
            prazo.setTime(prazo.getTime() + ((24 * 3600000) * qtdVencimento));
            GrupoComunitario grupoComunitario = new GrupoComunitario();
            grupoComunitario.setCriador(Session.getInstancia().getUsuarioLogado());
            grupoComunitario.setQuantidade(qtdItens);
            grupoComunitario.setCategoria((Categoria) cbCategoria.getSelectedItem());
            grupoComunitario.addComprador();
            grupoComunitario.setQrdDiasNotificacao(qtdAntecip);
            grupoComunitario.setPrazoValidade(prazo);
            
            try {
                Dao<Participante> daoParticipante = Factoring.getDaoParticipante();
                Dao<GrupoComunitario> daoGrupoComunitario = Factoring.getDaoGrupoComunitario();
                participante = new Participante();
                participante.setUsuario(Session.getInstancia().getUsuarioLogado());
                daoParticipante.grava(participante);
                grupoComunitario.addParticipante(participante);
                
                while(!listaParticipantes.isEmpty()){
                    participante = new Participante();
                    participante.setUsuario(listaParticipantes.firstElement());
                    daoParticipante.grava(participante);
                    grupoComunitario.addParticipante(participante);
                    
                    listaParticipantes.removeElement(participante);
                }
                daoGrupoComunitario.grava(grupoComunitario);
                
                tfDataVencimento.setText("");
                tfQtdDias.setText("");
                tfQtdItens.setText("");
                
                JOptionPane.showMessageDialog(null, "Grupo cadastrado com sucesso!");
                
            } catch (DaoException ex) {
                Logger.getLogger(FrameGrupoComunitario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btAddGrupoComunActionPerformed

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
            java.util.logging.Logger.getLogger(FrameGrupoComunitario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameGrupoComunitario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameGrupoComunitario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameGrupoComunitario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameGrupoComunitario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddCategoria;
    private javax.swing.JButton btAddGrupoComun;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btPraCa;
    private javax.swing.JButton btPraLa;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList lsMembrosRepublica;
    private javax.swing.JList lsParticipantesGrupo;
    private javax.swing.JTextField tfCriador;
    private javax.swing.JTextField tfDataVencimento;
    private javax.swing.JTextField tfQtdDias;
    private javax.swing.JTextField tfQtdItens;
    // End of variables declaration//GEN-END:variables
}
