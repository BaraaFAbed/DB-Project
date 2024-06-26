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
public class AddToCart extends javax.swing.JFrame {

    // Instance variables
    myDBCon dbCon;              // Database connection object
    ResultSet rs;               // Result set for account data
    ResultSet rsCheck1;          // Result Set for warehouse capacity data
    ResultSet rsCheck2;          // Result Set for warehouse capacity data
    LoginUser user;             // Stores currently logged in user
    int quantity;               // Product remaining quantity 
    double price;               // Product price
    String ID;                  // Product ID
    BrowseProducts parent;      // Stores parent jframe
    
    
    /**
     * Creates new form AddToCart
     */
    public AddToCart(LoginUser _user, String _ID, String _name, String _price, String _quantity, BrowseProducts _parent ) {
        // Initializes GUI components created using the form editor in NetBeans or similar IDE
        initComponents();
        
        // Getting parent JFrame
        parent = _parent;
        
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
        
        // Get ID,Quantity and price
        quantity = Integer.parseInt(_quantity);
        price = Double.parseDouble(_price);
        ID = _ID;
        
        // Display Product in boxes
        txtID.setText(_ID);
        txtName.setText(_name);
        txtPrice.setText(_price);
        txtQuantity.setText("0");
        
        // getting supplier
        user = _user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPriceError = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblIDError = new javax.swing.JLabel();
        lblNameError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblQuantityError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPriceError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblPriceError.setForeground(new java.awt.Color(255, 0, 0));
        lblPriceError.setText("error label");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name:");

        btnAddToCart.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Quantity:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("ID:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Price:");

        lblIDError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblIDError.setForeground(new java.awt.Color(255, 0, 0));
        lblIDError.setText("error label");

        lblNameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblNameError.setText("error label");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add to Cart");

        lblQuantityError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblQuantityError.setForeground(new java.awt.Color(255, 0, 0));
        lblQuantityError.setText("error label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddToCart)
                .addGap(298, 298, 298))
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(txtName))))
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
                            .addComponent(lblQuantityError, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(btnAddToCart)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInteger(String s) {
       try {
           Integer.parseInt(s);
           return true;
       } catch (NumberFormatException ex) {
           return false;
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
    
    boolean isValidData() {
       boolean result = true;
       
       // clears error labels
       clearErrorLabels();

       // Check if ID is empty or negative or not Int
       if (txtQuantity.getText().trim().isEmpty() || !isInteger(txtQuantity.getText().trim()) || Integer.parseInt(txtQuantity.getText().trim()) <= 0 ) {
           if (txtQuantity.getText().trim().isEmpty()) {
               lblQuantityError.setText("Invalid. Cannot be empty.");
           } else if (!isInteger(txtQuantity.getText().trim()) || Integer.parseInt(txtQuantity.getText().trim()) <= 0) {
               lblQuantityError.setText("Invalid. Must be a positive integer.");
           }
           lblQuantityError.setVisible(true);
           result = false;
       }
       
       return result;
   }
    
    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // Adding user to orderList if not
        if (OrderLine.orderLineList.get(user.username) == null)
        {
            OrderLine.orderLineList.put(user.username, new ArrayList<OrderLine>());
        }
        
        if (Integer.parseInt(txtQuantity.getText().trim()) <= quantity && isValidData())
        {
            OrderLine newOrder = new OrderLine(Integer.parseInt(txtQuantity.getText().trim())*price, user.username, Integer.parseInt(ID), Integer.parseInt(txtQuantity.getText().trim()), txtName.getText().trim());
            OrderLine.orderLineList.get(user.username).add(newOrder);
            JOptionPane.showMessageDialog(null, "Successfully added to cart");
            this.dispose();
//            try {
//                // Removing quantity from stock
//                String prepSQL = "UPDATE stores SET quantity = " + (quantity - Integer.parseInt(txtQuantity.getText().trim())) + " WHERE productID = " + ID;
//                String prepSQL1 = "UPDATE supplies SET quantity = " + (quantity - Integer.parseInt(txtQuantity.getText().trim())) + " WHERE productID = " + ID;
//                String prepSQL2 = "UPDATE transfer SET quantity = " + (quantity - Integer.parseInt(txtQuantity.getText().trim())) + " WHERE productID = " + ID;
//                dbCon.executePrepared(prepSQL);
//                dbCon.executePrepared(prepSQL1);
//                dbCon.executePrepared(prepSQL2);
//                                
//                JOptionPane.showMessageDialog(null, "Successfully added to cart");
//                parent.dispose();
//                (new BrowseProducts(user)).setVisible(true);
//                this.dispose();
//            } catch (SQLException e) {
//                // Display an error message if the deletion fails.
//                JOptionPane.showMessageDialog(null, "Error updating quantity.");
//            }
        }
        else
        {
            if (Integer.parseInt(txtQuantity.getText().trim()) > quantity)
                JOptionPane.showMessageDialog(null, "Not enough stock available");
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
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
