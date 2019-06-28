/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class Interface extends javax.swing.JFrame{
                int gu=0;
    int check;
    String lista1[] = new String[60]; //Armazena os dados brutos de cada documento.
    String array[] = new String[3];
    String array2[] = new String[15];
    String dados[][] = new String[60][15];
    String nomes1[] = new String[60];
    String nomes2[] = new String[60];
    char c;
    int pontos[] = new int[60];
    int pontos2[] = new int[60];
    DB BaseDados;
    
    DBCollection colecao;
    /**
     * Creates new form Interface
     */
    public Interface() {
 
        initComponents();
        setIcon();
        Mongo mong = new Mongo("192.168.137.1", 27017);
        BaseDados = mong.getDB("WebData");
        colecao = BaseDados.getCollection("Players");
        System.out.println("Conectado!");
        
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thanos Project");
        setPreferredSize(new java.awt.Dimension(1920, 1000));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CALCULAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1200, 890, 170, 50);

        txtA.setColumns(20);
        txtA.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txtA.setRows(5);
        jScrollPane1.setViewportView(txtA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 720, 990, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     mostrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/Manopla_Icon.png")));
    }
         
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    static BufferedReader read;
    
    
        public void mostrar(){
             int x =0;
            int i=0;
        DBCursor cursor = colecao.find();
        DBObject Objeto;
        while(cursor.hasNext()){
        Objeto = cursor.next();
            
        String resultado = Objeto.toString();
            lista1[i] = resultado;
            i++;
        }
        for (int u=0; u<i; u++){
        
        if (x == 0){    
        for (int t=0; t<i; t++){
            System.out.println(lista1[t]);
        }
        x=1;
        }
        for (int h=0; h<lista1[u].length(); h++){
            c = lista1[u].charAt(h);
            if (c == ','){
         check++;       
        }
        }
            System.out.println("Tamanho check: "+check);
        if (lista1[u] != null && check == 14){
        array2 = lista1[u].split(",");
        System.out.println("Split: "+u+"°");
        }else{
             
        } 

            
            if (dados[u][0] != "null"){
            for (int k=1; k<15; k++){
            dados[u][k] = array2[k];
            dados[u][k] = dados[u][k].replace("\"pecas\": ", "");
            dados[u][k] = dados[u][k].replace("\"preco total\": ", "");
            dados[u][k] = dados[u][k].replace("\"nome\": ", "");
            dados[u][k] = dados[u][k].replace("\"codigo\": ", "");
            dados[u][k] = dados[u][k].replace("\"", "");
            dados[u][k] = dados[u][k].replace("[", "");
            dados[u][k] = dados[u][k].replace("]", "");
            dados[u][k] = dados[u][k].replace("tempo: ", "");
            dados[u][k] = dados[u][k].replace("}", "");
            dados[u][k] = dados[u][k].replace("{", "");
            dados[u][k] = dados[u][k].replace("$numberLong: ", "");  
            dados[u][k] = dados[u][k].replace(" ", "");
            dados[u][k] = dados[u][k].toUpperCase();
            }   
        }
            check=0;
        }
        
        for (int p=0; p<i; p++){
        for (int j=1; j<15; j++){
            System.out.println(dados[p][j]);
        }
            System.out.printf("\n");
        }
        
        organiza(i);
    }
        
        public void organiza(int i){
            
            for (int r=0; r<i; r++){
                nomes1[r] = dados[r][1];

                if (dados[r][3].equals("CPU8100")){
                    pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU2700")){
                    pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU7400")){
                    pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU8400")){
                    pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU7700")){
                    pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU8700")){
                   pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU8300")){
                    pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU9590")){
                    pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU1600")){
                    pontos[r] = pontos[r] + 10;
                }else if (dados[r][3].equals("CPU1700")){
                    pontos[r] = pontos[r] + 10;
                }
                               
                if (dados[r][4].equals("MOBOSM5A78L")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][4].equals("MOBOSA990FXAM3")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSG78LMT")){
                    pontos[r] = pontos[r] + 10;
                }   
                else if(dados[r][4].equals("MOBOSAEX320M")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSGB450")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSGB450MG")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSGX470")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSMB450M")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSMB350M")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSAPB250M")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSMB250")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSATH310M")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSGB360M")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSMB60M")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][4].equals("MOBOSMH310M")){
                    pontos[r] = pontos[r] + 10;
                }
                                
                if (dados[r][5].equals("COOLINGCMBT2")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][5].equals("COOLINGCMMA")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGCMML240DF")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGCMML240R")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGCMMLL120")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGCMN120")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGCHSH100I")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGDCC240EX")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGDCIEM")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGNZXTKX62")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGPCYAC240")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGPCYSF240")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][5].equals("COOLINGTTFS12")){
                    pontos[r] = pontos[r] + 10;
                }
                 
                
                if(dados[r][6].equals("GPUAG1050TI")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][6].equals("GPUEG1060")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][6].equals("GPUEG2070")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][6].equals("GPUGG1660")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][6].equals("GPUGRT560")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][6].equals("GPUGRX570")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][6].equals("GPUGRX580")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][6].equals("GPUMG1050")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][6].equals("GPUPR550")){
                    pontos[r] = pontos[r] + 10;
                }
                
                if(dados[r][7].equals("RAMXPGD4")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][7].equals("RAMLPXD4")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][7].equals("RAMCRUD4")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][7].equals("RAMCRUBD4")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][7].equals("RAMKHXD44G")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][7].equals("RAMKHXD48G")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][7].equals("RAMK4D3")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][7].equals("RAMRM8D3")){
                    pontos[r] = pontos[r] + 10;
                }
                
                 
                if(dados[r][8].equals("RAMXPGD4")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][8].equals("RAMLPXD4")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][8].equals("RAMCRUD4")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][8].equals("RAMCRUBD4")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][8].equals("RAMKHXD44G")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][8].equals("RAMKHXD48G")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][8].equals("RAMK4D3")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][8].equals("RAMRM8D3")){
                    pontos[r] = pontos[r] + 10;
                }
                
                if(dados[r][9].equals("POWERCM450SM")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][9].equals("POWERCM1000")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERTUF750")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERCX450")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERCX650M")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERCX750")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERHX1000I")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERE550SM")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERE650")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERE850SM")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][9].equals("POWERE1300")){
                    pontos[r] = pontos[r] + 10;
                }
                
                if(dados[r][10].equals("STORAGEGAMMIX")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][10].equals("STORAGEMP300")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGEBX500")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGEA400")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGEA1000")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGE970EVO")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGESPLUS")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGECUDA2T")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGECUDA1T")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGEWDBLUE")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][10].equals("STORAGEWDPURPLE")){
                    pontos[r] = pontos[r] + 10;
                }
                
                if(dados[r][11].equals("STORAGEGAMMIX")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][11].equals("STORAGEMP300")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGEBX500")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGEA400")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGEA1000")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGE970EVO")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGESPLUS")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGECUDA2T")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGECUDA1T")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGEWDBLUE")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][11].equals("STORAGEWDPURPLE")){
                    pontos[r] = pontos[r] + 10;
                }
                
                
                if(dados[r][12].equals("CASEA500")){
                    pontos[r] = pontos[r] + 10;
                }else if(dados[r][12].equals("CASEA500G")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][12].equals("CASEA800")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][12].equals("CASEC700P")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][12].equals("CASEH500P")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][12].equals("CASE570X")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][12].equals("CASECCEMT")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][12].equals("CASEMADOKA")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][12].equals("CASEV200")){
                    pontos[r] = pontos[r] + 10;
                }
                else if(dados[r][12].equals("CASEV22")){
                    pontos[r] = pontos[r] + 10;
                }
                
                
                

            }

            for (int e=0; e<i; e++){
            for (int y=0; y<60; y++){
                if (nomes1[e].equals(nomes2[y]) == true){
                    gu = 1;
                }
            }
            if (gu == 0){
                nomes2[e] = nomes1[e];
                
            }
            gu=0;
            }
            
            for (int e=0; e<i; e++){
                if (nomes2[e] != null)
                 txtA.setText(txtA.getText()+"\n"+"Nomes: "+nomes2[e]+" Pontos: "+pontos[e]);
            }
            
        }
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txtA;
    // End of variables declaration//GEN-END:variables
}
