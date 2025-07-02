package university.managment.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class TeacherLeave extends JFrame implements ActionListener {
    JDateChooser dcdate;
    Choice cempid,ctime;
    JButton submit,cancel;
    TeacherLeave (){
        setSize(500,550);
        setLocation(550,100);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading=new JLabel("Apply Leave(Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lblrollno = new JLabel("Search by Empid");
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblrollno .setBounds(60, 100, 200, 20);
        add(lblrollno);

        cempid = new Choice();
        cempid.setBounds(60, 130, 200, 20);
        add(cempid);

        Exception e;
        ResultSet rs;
        Conn c;
        try {
            c = new Conn();
            rs = c.s.executeQuery("select * from teacher");

            while(rs.next()) {
                cempid.add(rs.getString("empid"));
            }
        } catch (Exception var5) {
            e = var5;
            e.printStackTrace();
        }


        JLabel lbldate = new JLabel("Date");
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbldate.setBounds(60, 180, 200, 20);
        add(lbldate);

        dcdate =new JDateChooser();
        dcdate.setBounds(60,210,200,30);
        add(dcdate);


        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbltime.setBounds(60, 260, 200, 20);
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Half Day");
        ctime.add("Full Day");
        add(ctime);

        submit =new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD, 15));
        add(submit);

        cancel =new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD, 15));
        add(cancel);


        setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== submit){
            String empid= cempid.getSelectedItem();
            String date=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query="insert into teacherleaves values('"+empid+"', '"+date+"', '"+duration+"')";

            try {
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave applied succesfully");
                setVisible(false);


            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}
