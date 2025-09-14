import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrom extends JDialog{
    private JTextField tfUsuario;
    private JPasswordField pfContraseña;
    private JButton btnOK;
    private JButton btnCancelar;
    private JPanel LoginPane;

    public LoginFrom(JFrame parent){
        super(parent);
        setTitle("login");
        setContentPane(LoginPane);
        setMaximumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(DISPOSE_ON_CLOSE);


        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Gmail = tfUsuario.getText();
                String Contraseña = String.valueOf(pfContraseña.getPassword());

                user = getAuthenticateUser(Gmail,Contraseña);
                if (user!=null){
                    dispose();
                }else{
                    JOptionPane.showMessageDialog (LoginFrom.this,
                    "usuario o contraseña invalida","try again",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public static User user;
    private User getAuthenticateUser(String Gmail , String Contraseña){
        User user = null;
        final String DB_URL = "";
        final String Usuario="";
        final String Contra ="";
        try {
            Connection conn = DriverManager.getConnection(DB_URL,Usuario,Contra);
            //conecta a la base de datos
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND Contraseña";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,Gmail);
            preparedStatement.setString(2,Contraseña);

            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                user=new User();
                user.Nombre=resultSet.getString("nombre");
                user.Gmail=resultSet.getString("gmail");
                user.NumCell =resultSet.getString("numero de celular");
                user.usuario=resultSet.getString("usuario");
                user.Crontraseña=resultSet.getString("contraseña");
            }
            stmt.close();
            conn.close();

        }catch (Exception e ){
            e.printStackTrace();
        }

        return user;
    }

    private void setLocationRelativeTo(int disposeOnClose) {

    }

    public static void main (String[] args){
        LoginFrom loginFrom = new LoginFrom (null);
        User user = LoginFrom.user;
        if (user!= null){
            System.out.println("registro exitoso "+ user.Nombre);
            System.out.println("  gmail:"+ user.Gmail);
            System.out.println("num Cell:"+user.NumCell);
            System.out.println("Usuario:"+ user.usuario);
        }else {
            System.out.println("error en los datos");
        }
    }

    private class connection {
    }
}
