package university.managment.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField tffname,tfname,tfadd,tfphn,tf10marks,tf12marks,tfaad,tfemail;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbqualification, cbdepartment;
    JButton  submit,cancel;

    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000l)+1000l);

    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);

        setLayout(null);
//heading
        JLabel heading=new JLabel("New Faculty Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
//Name
        JLabel name =new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        tfname =new JTextField();
        tfname.setBounds(200,150,150,30);
        tfname.setFont(new Font("serif",Font.BOLD,20));
        add(tfname);
//fathers name
        JLabel lblfname =new JLabel("Fathers Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        tffname =new JTextField();
        tffname.setBounds(600,150,200,30);
        tffname.setFont(new Font("serif",Font.BOLD,20));
        add(tffname);
//Roll no
        JLabel lblrollno =new JLabel("Emp id");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelempid =new JLabel("22151"+first4);
        labelempid.setBounds(200,200,200,30);
        labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);
//DOB
        JLabel lbldob =new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        dcdob =new JDateChooser();
        dcdob.setBounds(600,200,200,30);
        add(dcdob);
//Address
        JLabel lbladd =new JLabel("Address");
        lbladd.setBounds(50,250,200,30);
        lbladd.setFont(new Font("serif",Font.BOLD,20));
        add(lbladd);

        tfadd =new JTextField();
        tfadd.setBounds(200,250,150,30);
        tfadd.setFont(new Font("serif",Font.BOLD,20));
        add(tfadd);

//Phone
        JLabel lblphn =new JLabel("Phone");
        lblphn.setBounds(400,250,200,30);
        lblphn.setFont(new Font("serif",Font.BOLD,20));
        add(lblphn);

        tfphn =new JTextField();
        tfphn.setBounds(600,250,200,30);
        tfphn.setFont(new Font("serif",Font.BOLD,20));
        add(tfphn);

//Email
        JLabel lbemail =new JLabel("Email id");
        lbemail.setBounds(50,300,200,30);
        lbemail.setFont(new Font("serif",Font.BOLD,20));
        add(lbemail);

        tfemail =new JTextField();
        tfemail.setBounds(200,300,150,30);
        tfemail.setFont(new Font("serif",Font.BOLD,20));
        add(tfemail);

//class 10 marks
        JLabel lbl10marks =new JLabel("Class 10 (%) ");
        lbl10marks.setBounds(400,300,200,30);
        lbl10marks.setFont(new Font("serif",Font.BOLD,20));
        add(lbl10marks);

        tf10marks =new JTextField();
        tf10marks.setBounds(600,300,200,30);
        tf10marks.setFont(new Font("serif",Font.BOLD,20));
        add( tf10marks);

//class 12 marks
        JLabel lbl12marks =new JLabel("Class 12 (%)");
        lbl12marks.setBounds(50,350,200,30);
        lbl12marks.setFont(new Font("serif",Font.BOLD,20));
        add(lbl12marks);

        tf12marks =new JTextField();
        tf12marks.setBounds(200,350,150,30);
        tf12marks.setFont(new Font("serif",Font.BOLD,20));
        add(tf12marks);

//aadhar number
        JLabel lblaad =new JLabel("Aadhar no.");
        lblaad.setBounds(400,350,200,30);
        lblaad.setFont(new Font("serif",Font.BOLD,20));
        add(lblaad);

        tfaad =new JTextField();
        tfaad.setBounds(600,350,200,30);
        tfaad.setFont(new Font("serif",Font.BOLD,20));
        add(tfaad);
//course
        JLabel lblcourse =new JLabel("Qualification");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);

        String course[]={"B.tech","BA","BBA","BCA","B.com","Bsc it","MCA","MBA","MA","M.tech","Msc"};
        cbqualification =new JComboBox<>(course);
        cbqualification.setBounds(200,400,150,30);
        cbqualification.setBackground(Color.white);
        add(cbqualification);
//branch
        JLabel lblbranch =new JLabel("Department");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);

        String branch[]={"Computer Science","Mechanical","ELectrical","Civil","IT",};
        cbdepartment =new JComboBox<>(branch);
        cbdepartment.setBounds(600,400,200,30);
        cbdepartment.setBackground(Color.white);
        add(cbdepartment);

        submit =new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD, 15));
        add(submit);

        cancel =new JButton("Cancel");
        cancel.setBounds(400,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD, 15));
        add(cancel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String name=tfname.getText();
            String fname=tffname.getText();
            String empid = labelempid.getText();
            String dob= ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address=tfadd.getText();
            String phn= tfphn.getText();;
            String email=tfemail.getText();
            String x=tf10marks.getText();
            String xii= tf12marks.getText();;
            String aadhar=tfaad.getText();
            String qualification = (String) cbqualification.getSelectedItem();
            String department =(String) cbdepartment.getSelectedItem();
            try{
                String query="insert into Teacher values('"+name+"','"+fname+"','"+ empid +"','"+dob+"','"+address+"','"+phn+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+ qualification +"','"+ department +"')";

                Conn con=new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Faculty Details Inserted Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddTeacher();
    }


}

