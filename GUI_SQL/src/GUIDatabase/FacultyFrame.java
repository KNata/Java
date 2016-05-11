package GUIDatabase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class FacultyFrame extends javax.swing.JFrame {

    
    public FacultyFrame() {
        initData();
        initComponents();
        buttonGroup1.add(course);
        buttonGroup1.add(student);
        buttonGroup1.add(teacher);
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        checkButton = new javax.swing.JButton();
        field = new javax.swing.JTextField();
        student = new javax.swing.JCheckBox();
        course = new javax.swing.JCheckBox();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        teacher = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 2, 18)); 
        jLabel1.setText("University data...");

        checkButton.setText("Check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        field.setText("Enter name");

        student.setText("Student");

        course.setText("Course");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        teacher.setText("Teacher");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teacher)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(student))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(course)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(student))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacher))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
        jMenuItem1.setText("Exit");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {

        String input = field.getText();
        int id =0;
        if(student.isSelected())
            try{
         id =   checkStudent(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
       else   if(course.isSelected())
            try{
           id = checkCourse(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
        else   
            try{
           id = checkTeacher(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
        if(id!=-1)
        {
            JOptionPane.showMessageDialog(this.jPanel1,"Your query was found in database id ="+id,"Success",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this.jPanel1,"No data to match your query","Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
     
        String input = field.getText();
       
        if(student.isSelected())
            try{
           insertStudent(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
       else   if(course.isSelected())
            try{
            insertCourse(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
        else   
            try{
            insertTeacher(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
        
            JOptionPane.showMessageDialog(this.jPanel1,"Your data was inserted","Success",JOptionPane.INFORMATION_MESSAGE);
       
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
             String input = field.getText();
       
        if(student.isSelected())
            try{
           deleteStudent(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
       else   if(course.isSelected())
            try{
            deleteCourse(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
        else   
            try{
            deleteTeacher(input);
            }
        catch(Exception c)
        {
            c.printStackTrace();
        }
        
            JOptionPane.showMessageDialog(this.jPanel1,"Your data was deleted","Success",JOptionPane.INFORMATION_MESSAGE);
       
                                           

    } 

      private Connection con;
    private Statement statement;
    private ResultSet resSet;
    

	private void initData() {
		  try{
	            Class.forName("org.sqlite.JDBC");
	            con = DriverManager.getConnection("jdbc:sqlite:faculty.db");
	            PreparedStatement st = con.prepareStatement("create table if not exists 'students' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text);");
	            PreparedStatement st2 = con.prepareStatement("create table if not exists 'teachers' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text);");
	            PreparedStatement st3 = con.prepareStatement("create table if not exists 'courses' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");
	            int result = st.executeUpdate();
	            int result2 = st2.executeUpdate();
	            int result3 = st3.executeUpdate();
	        }catch(ClassNotFoundException e){
	            System.out.println("JDBC wasn't found");
	            e.printStackTrace();
	            System.exit(0);
	        }catch (SQLException e){
	            System.out.println("Wrong SQL");
	            e.printStackTrace();
	        }   		
	}
	private void insertStudent(String input) throws Exception
	{
		try{
		String[] args = input.split("\\s+");
		Student temp = Service.getStudent(args[0], args[1]);
		PreparedStatement statement = con.prepareStatement("INSERT INTO students(name,surname) VALUES (?,?)");
		statement.setString(1, temp.getName());
		statement.setString(2, temp.getSurname());

        int result = statement.executeUpdate();

        statement.close();
    }catch (SQLException e){
        System.out.println("Wrong SQL");
        e.printStackTrace();
    }
	}
	
	private void insertTeacher(String input) throws Exception {
		try{
		String[] args = input.split("\\s+");
		Teacher temp = Service.getTeacher(args[0], args[1]);
		PreparedStatement statement = con.prepareStatement("INSERT INTO teachers(name,surname) VALUES (?,?)");
		statement.setString(1, temp.getName());
		statement.setString(2, temp.getSurname());

        int result = statement.executeUpdate();

        statement.close();
    } catch (SQLException e) {
        System.out.println("Wrong SQL");
        e.printStackTrace();
    }
	}
	
	private void insertCourse(String input) throws Exception {
		try{
		Course course = Service.getCourse(input);
		PreparedStatement statement = con.prepareStatement("INSERT INTO courses(name) VALUES (?)");
		statement.setString(1, course.getName());
        int result = statement.executeUpdate();
        statement.close();
    }catch (SQLException e){
        System.out.println("Wrong SQL");
        e.printStackTrace();
    }
	}
	
	
	private int checkStudent(String input) throws Exception{
		try{
			String[] args = input.split("\\s+");
			Student student = Service.getStudent(args[0], args[1]);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM students");
			  while (res.next()) {
	               if(res.getString("name").equals(student.getName())&&res.getString("surname").equals(student.getSurname()))
	            	    return res.getShort("id");
	            }
			
		}
		catch (SQLException ex){
			 System.out.println("Wrong SQL");
	            ex.printStackTrace();	
		}
		return -1;
	}
	private int checkTeacher(String input) throws Exception{
		try{
			String[] args = input.split("\\s+");
			Teacher teacher = Service.getTeacher(args[0], args[1]);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM teachers");
			  while (res.next()) {
	               if(res.getString("name").equals(teacher.getName())&&res.getString("surname").equals(teacher.getSurname()))
	            	    return res.getShort("id");
	            }
			
		}
		catch (SQLException ex){
			 System.out.println("Wrong SQL");
	            ex.printStackTrace();	
		}
		return -1;
	}
	private int checkCourse(String input) throws Exception{
		try{
			Course course = Service.getCourse(input);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM courses");
			  while (res.next()) {
	               if(res.getString("name").equals(course.getName()))
	            	    return res.getShort("id");
	            }
			
		}
		catch (SQLException ex){
			 System.out.println("Wrong SQL");
	            ex.printStackTrace();	
		}
		return -1;
	}
	private void deleteStudent(String input) throws Exception{
		int id = checkStudent(input);
		if(id == -1) return;
		  try{
	            Statement st = con.createStatement();
	            st.execute("delete from 'students' where id = " + id + ";");
	            st.close();
	        }catch(SQLException e){
	            System.out.println("Wrong SQL");
	            e.printStackTrace();
	        }
	    }
	
	private void deleteTeacher(String input) throws Exception{
		int id = checkTeacher(input);
		if(id == -1) return;
		  try{
	            Statement st = con.createStatement();
	            st.execute("delete from 'teachers' where id = " + id + ";");
	            st.close();
	        }catch(SQLException e){
	            System.out.println("Wrong SQL");
	            e.printStackTrace();
	        }
	    }
	
	
	private void deleteCourse(String input) throws Exception{
		int id = checkCourse(input);
		if(id == -1) return;
		  try{
	            Statement st = con.createStatement();
	            st.execute("delete from 'courses' where id = " + id + ";");
	            st.close();
	        }catch(SQLException e){
	            System.out.println("Wrong SQL");
	            e.printStackTrace();
	        }
	    }
	
	  private void showAllData(){
	        try{
	            Statement st = con.createStatement();
	            ResultSet res = st.executeQuery("SELECT * FROM students");
	            while (res.next()) {
	                String name = res.getString("name");
	                String surname = res.getString("surname");
	                System.out.println (res.getShort("id")+" "+name+ " " +surname);
	            }
	            res.close();
	            st.close();
	        }catch(SQLException e){
	            System.out.println("Wrong SQL");
	            e.printStackTrace();
	        }
	    }
	  
	  
	  private void showAllData2(){
	        try{
	            Statement st = con.createStatement();
	            ResultSet res = st.executeQuery("SELECT * FROM teachers");
	            while (res.next()) {
	                String name = res.getString("name");
	                String surname = res.getString("surname");
	                System.out.println (res.getShort("id")+" "+name+ " " +surname);
	            }
	            res.close();
	            st.close();
	        }catch(SQLException e){ 
	            System.out.println("Wrong SQL");
	            e.printStackTrace();
	        }
	    }
    

   
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton checkButton;
    private javax.swing.JCheckBox course;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox student;
    private javax.swing.JCheckBox teacher;
  
}
