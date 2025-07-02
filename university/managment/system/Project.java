package university.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    JMenu about,exit;
    JMenuItem Ex,ab;

    Project() {
        setSize(1500, 768);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/university.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
//new information
        JMenu newinformation = new JMenu("New Information");
        newinformation.setForeground(Color.BLUE);
        mb.add(newinformation);

        JMenuItem facultyinfo = new JMenuItem("New Faculty Information");
        facultyinfo.setBackground(Color.white);
        facultyinfo.addActionListener(this);
        newinformation.add(facultyinfo);

        JMenuItem studentinfo = new JMenuItem("New Student Information");
        studentinfo.setBackground(Color.white);
        studentinfo.addActionListener(this);
        newinformation.add(studentinfo);

// details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultydetail = new JMenuItem("View Faculty Details");
        facultydetail.setBackground(Color.white);
        facultydetail.addActionListener(this);
        details.add(facultydetail);

        JMenuItem studentdetail = new JMenuItem("View Student Details");
        studentdetail.setBackground(Color.white);
        studentdetail.addActionListener(this);
        details.add(studentdetail);
        //apply leaves
        JMenu leaves = new JMenu("Apply Leaves");
        leaves.setForeground(Color.BLUE);
        mb.add(leaves);

        JMenuItem facultyleaves = new JMenuItem("Faculty Leaves");
        facultyleaves.setBackground(Color.white);
        facultyleaves.addActionListener(this);
        leaves.add(facultyleaves);

        JMenuItem studentleaves = new JMenuItem("Student Leaves");
        studentleaves.addActionListener(this);
        studentleaves.setBackground(Color.white);
        leaves.add(studentleaves);

// view leaves
        JMenu viewleaves = new JMenu("View leaves");
        viewleaves.setForeground(Color.RED);
        mb.add(viewleaves);

        JMenuItem viewfacultyleaves = new JMenuItem("View Faculty Leaves");
        viewfacultyleaves.setBackground(Color.white);
        viewfacultyleaves.addActionListener(this);
        viewleaves.add(viewfacultyleaves);

        JMenuItem viewStudentLeaves = new JMenuItem("View Student Leaves");
        viewStudentLeaves.setBackground(Color.white);
        viewStudentLeaves.addActionListener(this);
        viewleaves.add(viewStudentLeaves);

// Examination
        JMenu examination = new JMenu("Examination");
        examination.setForeground(Color.BLUE);
        mb.add(examination);

        JMenuItem examinationresult = new JMenuItem("Examination Result");
        examinationresult.setBackground(Color.white);
        examinationresult.addActionListener(this);
        examination.add(examinationresult);

        JMenuItem examinationmarks = new JMenuItem("Enter Marks");
        examinationmarks.addActionListener(this);
        examinationmarks.setBackground(Color.white);
        examination.add(examinationmarks);

// Update
        JMenu update = new JMenu("Update Details");
        update.setForeground(Color.RED);
        mb.add(update);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.white);
        updatefacultyinfo.addActionListener(this);
        update.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.addActionListener(this);
        updatestudentinfo.setBackground(Color.white);
        update.add(updatestudentinfo);
// fee
        JMenu fee = new JMenu("fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee structure");
        feestructure.addActionListener(this);
        feestructure.setBackground(Color.white);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("fill fee form");
        feeform.addActionListener(this);
        feeform.setBackground(Color.white);
        fee.add(feeform);

// utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        utility.add(calc);
// About

        about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);

        ab = new JMenuItem("About");
        ab.addActionListener(this);
        ab.setBackground(Color.white);
        about.add(ab);

// exit
        exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);

        Ex = new JMenuItem("Exit");
        Ex.addActionListener(this);
        Ex.setBackground(Color.white);
        exit.add(Ex);


        setJMenuBar(mb);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Project();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {

            }
        } else if ((msg.equals("Notepad"))) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {

            }
        }
            else if(msg.equals("New Student Information")){
                new AddStudent();
            } else if (msg.equals("New Faculty Information")) {
               new AddTeacher();
        }
        else if (msg.equals("View Faculty Details")) {
//            new AddTeacher();
            new FacultyDetails();
        }
        else if (msg.equals("View Student Details")) {
            new StudentDetails();
        }
        else if (msg.equals("Faculty Leaves")) {
            new TeacherLeave();
        }
        else if (msg.equals("Student Leaves")) {
            new StudentLeave();
        }
        else if (msg.equals("View Faculty Leaves")) {
            new FacultyLeaveDetails();
        }
        else if (msg.equals("View Student Leaves")) {
            new StudentLeaveDetails();
        }
        else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        }
        else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        }
        else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        }
        else if (msg.equals("Examination Result")) {
            new ExaminationDetails();
        }
        else if (msg.equals("About")) {
            new About();
        }
        else if (msg.equals("Fee structure")) {
            new FeeStructure();
        }
        else if (msg.equals("fill fee form")) {
            new StudentFeeForm();
        }



    }
}
