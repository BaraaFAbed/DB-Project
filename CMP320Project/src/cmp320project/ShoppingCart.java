package cmp320project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.*;


/**
 *
 * @author baraa
 */
public class ShoppingCart extends javax.swing.JFrame {

    // Instance variables
    myDBCon dbCon;              // Database connection object
    ResultSet rs;               // Result set for account data
    ResultSet rs2;               // Result set for account data
    LoginUser user;             // Stores currently logged in user
    int index;                  // Index of array list
    
    /**
     * Creates new form ShoppingCart
     */
    public ShoppingCart(LoginUser _user) {
        // Initializes GUI components created using the form editor in NetBeans or similar IDE
        initComponents();
        
        // creating connection
        dbCon = new myDBCon();
        
        // Positions this JFrame to the center of the screen
        this.setLocationRelativeTo(null);
        
        // set all error labels to invisible
        lblIDError.setVisible(false);
        lblNameError.setVisible(false);
        lblPriceError.setVisible(false);
        lblQuantityError.setVisible(false);

        // Initialize the database connection
        dbCon = new myDBCon();
        
        // getting supplier
        user = _user;
        
        // Fetch and display new data from the database to populate the form
        getNewData();
        
    }

    // This method fetches and sets the data from the database to populate the form's fields
    private void getNewData() {
        index = 0;
        try {
            // Query to fetch account details of employees
            rs = dbCon.executeStatement("SELECT product.productID, name, price, Quantity FROM product, supplies WHERE product.productID = supplies.productID ORDER BY productID ASC ");
            
            // Moves the cursor of the result set to the first row and populates the form fields with data
            rs.beforeFirst();
            rs.first();
            populateFields();
        } catch (SQLException e) {
            // Display an error message in case of any SQL exceptions
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Display selected product.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
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

        lblNameError = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblQuantityError = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPriceError = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnRemoveFromCart = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblIDError = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        btnCheckout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblNameError.setText("error label");

        btnPrevious.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnPrevious.setText("<< Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Shopping Cart");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name:");

        lblQuantityError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblQuantityError.setForeground(new java.awt.Color(255, 0, 0));
        lblQuantityError.setText("error label");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Quantity:");

        lblPriceError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblPriceError.setForeground(new java.awt.Color(255, 0, 0));
        lblPriceError.setText("error label");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Price:");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnRemoveFromCart.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnRemoveFromCart.setText("Remove");
        btnRemoveFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromCartActionPerformed(evt);
            }
        });

        txtQuantity.setEditable(false);
        txtQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("ID:");

        lblIDError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblIDError.setForeground(new java.awt.Color(255, 0, 0));
        lblIDError.setText("error label");

        btnNext.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnNext.setText("Next >>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCheckout.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnCheckout.setText("Checkout");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantity)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtName))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblIDError, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPriceError, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblQuantityError, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveFromCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriceError)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantityError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnRemoveFromCart)
                    .addComponent(btnCheckout))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateFields() {
        try {
            rs2 = dbCon.executeStatement("SELECT product.productID, name, price, Quantity FROM product, supplies WHERE product.productID = supplies.productID AND product.ProductID = " + Integer.toString(OrderLine.orderLineList.get(user.username).get(index).getProductID()));
            rs2.next();
            // Setting form fields with the current row's data from the result set.
            txtID.setText(Integer.toString(OrderLine.orderLineList.get(user.username).get(index).getProductID()));
            txtName.setText(rs2.getString("Name"));
            txtPrice.setText(rs2.getString("Price"));
            txtQuantity.setText(Integer.toString(OrderLine.orderLineList.get(user.username).get(index).getQuantity()));
            
            // Update the navigation buttons' states.
            EnableDisableButtons();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // This method moves the result set's cursor to the next record and populates the form fields.
    private void MoveNext() {
        if (!(index + 1 > OrderLine.orderLineList.get(user.username).size() - 1)) {
            index++;
            populateFields();
        }
    }
    
    // This method moves the result set's cursor to the previous record and populates the form fields.
    private void MovePrevious() {
        if (!(index - 1 < 0)) {
            index--;
            populateFields();
        }
    }

    // This method updates the state of the navigation buttons based on the cursor's position in the result set.
    private void EnableDisableButtons() {
        // Disable the Previous button if we're at the first record.
        if (index == 0) {
            btnPrevious.setEnabled(false);
        } else {
            btnPrevious.setEnabled(true);
        }

        // Disable the Next button if we're at the last record.
        if (index == OrderLine.orderLineList.get(user.username).size() - 1) {
            btnNext.setEnabled(false);
        } else {
            btnNext.setEnabled(true);
        }

    }
    
    void clearErrorLabels() {
        // erase error label text and set visibility to false
        lblIDError.setText("");
        lblIDError.setVisible(false);
        lblNameError.setText("");
        lblNameError.setVisible(false);
        lblPriceError.setText("");
        lblPriceError.setVisible(false);
        lblQuantityError.setText("");
        lblQuantityError.setVisible(false);
    }
    
    /**
    * This method checks if the provided string can be parsed as an integer.
    * @param s The string to check.
    * @return true if the string can be parsed as an integer, false otherwise.
    */
   public boolean isInteger(String s) {
       try {
           Integer.parseInt(s);
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }

   /**
    * This method checks if the provided string can be parsed as a double.
    * @param s The string to check.
    * @return true if the string can be parsed as a double, false otherwise.
    */
   public boolean isDouble(String s) {
       try {
           Double.parseDouble(s);
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }
    
    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        MovePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnRemoveFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromCartActionPerformed
        OrderLine.orderLineList.get(user.username).remove(0);
        getNewData();
    }//GEN-LAST:event_btnRemoveFromCartActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        MoveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here:
        (new CheckoutForm(user, this)).setVisible(true);
    }//GEN-LAST:event_btnCheckoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnRemoveFromCart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblIDError;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPriceError;
    private javax.swing.JLabel lblQuantityError;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
