package cmp320project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baraa
 */
public class PurchaseHistoryForm extends javax.swing.JFrame {

    myDBCon dbCon;              // Database connection object
    ResultSet rs;     
    String username;
    String startDate;
    String endDate;
    
    /**
     * Creates new form PurchaseHistoryForm
     */
    public PurchaseHistoryForm(String username) {
        // Initializes GUI components created using the form editor in NetBeans or similar IDE
        initComponents();

        //setting startDate and stop Date
        startDate = "CURRENT_DATE - 1";
        endDate = "CURRENT_DATE";
        
        // Setting product label text
        jProductLabel.setText(username);
        
        // Disabling error labels
        lblStartError.setVisible(false);
        lblEndError.setVisible(false);
        
        // getiing product ID
        this.username = username;
        
        // Positions this JFrame to the center of the screen
        this.setLocationRelativeTo(null);
        
        // Initialize the database connection
        dbCon = new myDBCon();

        // Call function to populate table
        populateTable();
    }

    private void populateTable()
    {
        try {
            double totalC = 0;
            int totalQ = 0;
            rs = dbCon.executeStatement("SELECT O.OrderID, OL.productID, OL.quantity, LineTotal, SP.username, orderdate FROM orderline OL, \"Order\" O, Supplies SP WHERE SP.productID = OL.productID AND O.orderID = OL.orderID AND O.username = '" + username + "' AND orderdate  BETWEEN " + startDate + " AND " + endDate + " ORDER BY orderdate DESC");
            DefaultTableModel model = (DefaultTableModel) jCheckoutTable.getModel();
            Object[] temp = {null, null, null ,null, null, null};
            while (rs.next())
            {
                temp = new Object[]{rs.getString("OrderID"), rs.getString("ProductID"), rs.getString("Quantity"),rs.getString("LineTotal"),rs.getString("username"), rs.getString("OrderDate")};
                model.addRow(temp);
                totalC += Double.parseDouble(rs.getString("LineTotal"));
                totalQ += Integer.parseInt(rs.getString("Quantity"));
            }
            temp = new Object[]{"Totals:", "", Integer.toString(totalQ), Double.toString(totalC), "", ""};
            model.addRow(temp);            
        } catch (SQLException ex) {
            Logger.getLogger(TransferHistoryForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jCheckoutTable = new javax.swing.JTable();
        jProductLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStart = new javax.swing.JTextField();
        lblStartError = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEnd = new javax.swing.JTextField();
        lblEndError = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jCheckoutTable.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jCheckoutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Product ID", "Quantity", "Cost", "Supplier", "Order Date"
            }
        ));
        jCheckoutTable.setToolTipText("");
        jCheckoutTable.setEnabled(false);
        jScrollPane1.setViewportView(jCheckoutTable);

        jProductLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jProductLabel.setText("Username");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Start Date:");

        txtStart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblStartError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblStartError.setForeground(new java.awt.Color(255, 0, 0));
        lblStartError.setText("error label");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("End Date:");

        txtEnd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblEndError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEndError.setForeground(new java.awt.Color(255, 0, 0));
        lblEndError.setText("error label");

        btnUpdate.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnUpdate.setText("Update Table");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtEnd)
                                    .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStartError, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                    .addComponent(lblEndError, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jProductLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProductLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStartError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //TODO
        clearErrorLabels();
        if (isValidData())
        {
            startDate = "'" + txtStart.getText().trim() + "'";
            endDate = "'" +  txtEnd.getText().trim() + "'";
            DefaultTableModel model = (DefaultTableModel) jCheckoutTable.getModel();
            model.setRowCount(0);
            populateTable();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
    * This method validates the data entered in the form.
    * @return true if all data is valid, false if any data is invalid.
    */
   boolean isValidData() {
       boolean result = true;

        // Validation for start date
        if (txtStart.getText().trim().isEmpty()) {
            lblStartError.setText("Invalid. Cannot be empty.");
            lblStartError.setVisible(true);
            result = false;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            dateFormat.setLenient(false); // This will make sure the format is strict

            try {
                Date StartDate = dateFormat.parse(txtStart.getText().trim());
                // If parsing is successful, it means the format is correct
            } catch (ParseException e) {
                lblStartError.setText("Invalid date format. Use DD-MON-YYYY");
                lblStartError.setVisible(true);
                result = false;
            }
        }


       // Validation for start date
        if (txtEnd.getText().trim().isEmpty()) {
            lblEndError.setText("Invalid. Cannot be empty.");
            lblEndError.setVisible(true);
            result = false;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            dateFormat.setLenient(false); // This will make sure the format is strict

            try {
                Date EndDate = dateFormat.parse(txtEnd.getText().trim());
                // If parsing is successful, it means the format is correct
            } catch (ParseException e) {
                lblEndError.setText("Invalid date format. Use DD-MON-YYYY");
                lblEndError.setVisible(true);
                result = false;
            }
        }

       return result;
   }

   void clearErrorLabels() {
        // erase error label text and set visibility to false
        lblStartError.setText("");
        lblStartError.setVisible(false);
        lblEndError.setText("");
        lblEndError.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable jCheckoutTable;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jProductLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEndError;
    private javax.swing.JLabel lblStartError;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtStart;
    // End of variables declaration//GEN-END:variables
}
