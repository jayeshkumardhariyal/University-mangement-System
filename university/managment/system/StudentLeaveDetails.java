package university.managment.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice crollno;
    JTable table;
    JButton search;
    JButton print;
    JButton cancel;

    StudentLeaveDetails() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout((LayoutManager)null);
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);

        Exception e;
        ResultSet rs;
        Conn c;
        try {
            c = new Conn();
            rs = c.s.executeQuery("select * from student");

            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception var5) {
            e = var5;
            e.printStackTrace();
        }

        table = new JTable();

        try {
            c = new Conn();
            rs = c.s.executeQuery("select * from studentleaves");
            this.table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception var4) {
            e = var4;
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(this.table);
        jsp.setBounds(0, 100, 900, 600);
        this.add(jsp);
        this.search = new JButton("Search");
        this.search.setBounds(20, 70, 80, 20);
        this.search.addActionListener(this);
        this.add(this.search);
        this.print = new JButton("Print");
        this.print.setBounds(120, 70, 80, 20);
        this.print.addActionListener(this);
        this.add(this.print);
        this.cancel = new JButton("Cancel");
        this.cancel.setBounds(220, 70, 80, 20);
        this.cancel.addActionListener(this);
        this.add(this.cancel);
        this.setSize(900, 700);
        this.setLocation(300, 100);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.search) {
            String query = "select * from studentleaves where rollno = '" + this.crollno.getSelectedItem() + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                this.table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception var6) {
                Exception e = var6;
                e.printStackTrace();
            }
        } else if (ae.getSource() == this.print) {
            try {
                this.table.print();
            } catch (Exception var5) {
                Exception e = var5;
                e.printStackTrace();
            }
        }
         else {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}

