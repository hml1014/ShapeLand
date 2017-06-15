package shapes;

/*
 * This class constructs a GUI that allows
 * the user to create Shapes and perform 
 * operations on them.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ShapeLand extends JFrame {
	private static final long serialVersionUID = 1L;
	final Container cp;
	private JPanel view, selections, points, options, darts;
	private JTextArea a, a2;
	private JScrollPane sp, sp2;
	private JRadioButton rPoint, rLine, rEllipse, rCircle, rRectangle, rSquare, rTriangle;
	private ButtonGroup b;
	private JTextField p1x, p1y, p2x, p2y, p3x, p3y, shapeId, dx, dy;
	private JLabel p1xLabel, p1yLabel, p2xLabel, p2yLabel, p3xLabel, p3yLabel, idLabel;
	private JButton submit, area, perimeter, throwDart, delete, update, resubmit;
	private AtomicInteger pCount, lCount, eCount, cCount, rCount, sCount, tCount;
	private ArrayList<Shape> shapes;
	
	public ShapeLand(){
		cp = getContentPane();
	    cp.setLayout(new BoxLayout(cp, 3)); 
	    
	    shapes = new ArrayList<Shape>();
	    
	    /* Set counters for number ids */
	    pCount = new AtomicInteger();
	    lCount = new AtomicInteger();
	    eCount = new AtomicInteger();
	    cCount = new AtomicInteger();
	    rCount = new AtomicInteger();
	    sCount = new AtomicInteger();
	    tCount = new AtomicInteger();
	    
	    /* Create view panel */
	    view = new JPanel();
	    a = new JTextArea("",15,22);
	    a.setEditable(false);
	    sp = new JScrollPane(a);
	    a2 = new JTextArea("",15,22);
	    a2.setEditable(false);
	    sp2 = new JScrollPane(a2);
	    view.add(sp);
	    view.add(sp2);
	    cp.add(view);
	    
	    /* Create shape selection radio buttons */
	    selections = new JPanel(new FlowLayout());
	    b = new ButtonGroup();
	    rPoint = new JRadioButton("Point",true);
	    b.add(rPoint);
	    rLine = new JRadioButton("Line", false);
	    b.add(rLine);
	    rEllipse = new JRadioButton("Ellipse", false);
	    b.add(rEllipse);
	    rCircle = new JRadioButton("Circle", false);
	    b.add(rCircle);
	    rRectangle = new JRadioButton("Rectangle", false);
	    b.add(rRectangle);
	    rSquare = new JRadioButton("Square", false);
	    b.add(rSquare);
	    rTriangle = new JRadioButton("Triangle", false);
	    b.add(rTriangle);
	    
	    selections.add(rPoint);
	    selections.add(rLine);
	    selections.add(rEllipse);
	    selections.add(rCircle);
	    selections.add(rRectangle);
	    selections.add(rSquare);
	    selections.add(rTriangle);
	    cp.add(selections);
	    
	    /* Create point textfields */
	    points = new JPanel(new FlowLayout());
	    p1xLabel = new JLabel("X:");
	    p1x = new JTextField("",3);
	    p1yLabel = new JLabel("Y:");
	    p1y = new JTextField("",3);
	    p2xLabel = new JLabel("");
	    p2x = new JTextField("",3);
	    p2yLabel = new JLabel("");
	    p2y = new JTextField("",3);
	    p3xLabel = new JLabel("");
	    p3x = new JTextField("",3);
	    p3yLabel = new JLabel("");
	    p3y = new JTextField("",3);
	    submit = new JButton("Submit");
	    resubmit = new JButton("Resubmit");
	    
	    p2xLabel.setVisible(false);
	    p2x.setVisible(false);
	    p2yLabel.setVisible(false);
	    p2y.setVisible(false);
	    p3xLabel.setVisible(false);
	    p3x.setVisible(false);
	    p3yLabel.setVisible(false);
	    p3y.setVisible(false);
	    resubmit.setVisible(false);
	    
	    points.add(p1xLabel);
	    points.add(p1x);
	    points.add(p1yLabel);
	    points.add(p1y);
	    points.add(p2xLabel);
	    points.add(p2x);
	    points.add(p2yLabel);
	    points.add(p2y);
	    points.add(p3xLabel);
	    points.add(p3x);
	    points.add(p3yLabel);
	    points.add(p3y);
	    points.add(submit);
	    points.add(resubmit);
	    cp.add(points);
	    
	    /* Set other options */
	    options = new JPanel(new FlowLayout());
	    idLabel = new JLabel("Shape Id:");
	    options.add(idLabel);
	    shapeId = new JTextField("" , 3);
	    options.add(shapeId);
	    area = new JButton("Area");
	    options.add(area);
	    perimeter = new JButton("Perimeter");
	    options.add(perimeter);
	    delete = new JButton("Delete");
	    options.add(delete);
	    update = new JButton("Update");
	    options.add(update);
	    cp.add(options);
	    
	    /* Create dart panel */
	    darts = new JPanel();
	    darts.add(new JLabel("X:"));
	    dx = new JTextField("",3);
	    darts.add(dx);
	    darts.add(new JLabel("Y:"));
	    dy = new JTextField("",3);
	    darts.add(dy);
	    throwDart = new JButton("Throw Dart");
	    darts.add(throwDart);
	    cp.add(darts);
	
	    /* Set window properties */
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    setSize(700,500);
	    setTitle("ShapeLand");         
	    setVisible(true);
	    
	    /* Add Action Listeners  */
	    rPoint.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent evt) {
	        	setPointOptions();
	         }
	    });
	    
	    rLine.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent evt) {
	        	setLineOptions();
	         }
	    });
	    
	    rEllipse.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent evt) {
	        	setEllipseOptions();
	         }
	    });
	    
	    rCircle.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent evt) {
	        	setCircleOptions();
	         }
	    });
	    
	    rRectangle.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent evt) {
	        	setRectangleOptions();
	         }
	    });
	    
	    rSquare.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent evt) {
	        	setRectangleOptions();
	         }
	    });
	    
	    rTriangle.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent evt) {
	        	setTriangleOptions();
	         }
	    });
	    
	    submit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent evt) {
	    		if (rPoint.isSelected()) createPoint();
	    		else if (rLine.isSelected()) createLine();
	    		else if (rEllipse.isSelected()) createEllipse();
	    		else if (rCircle.isSelected()) createCircle();
	    		else if (rRectangle.isSelected()) createRectangle();
	    		else if (rSquare.isSelected()) createSquare();
	    		else if (rTriangle.isSelected()) createTriangle();
	    	}
	    });
	    
	    area.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		if (shapes.size() == 0) JOptionPane.showMessageDialog(null, "There are currently no shapes stored.");
	    		else{
	    			String id = shapeId.getText();
	    			if (containsShape(id)){
	    				int j = findShape(id);
	    				String c = shapes.get(j).toString();
	    				double ar = shapes.get(j).area();
	    				a2.setText(c + "\n");
	    				a2.append("Area: "+ar);
	    			}else JOptionPane.showMessageDialog(null, "There is no shape with the id "+id);
	    		}
	    	}
	    });
	    
	    perimeter.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		if (shapes.size() == 0) JOptionPane.showMessageDialog(null, "There are currently no shapes stored.");
	    		else{
	    			String id = shapeId.getText();
	    			if (containsShape(id)){
	    				int j = findShape(id);
	    				String c = shapes.get(j).toString();
	    				double pe = shapes.get(j).perimeter();
	    				a2.setText(c + "\n");
	    				a2.append("Perimeter: "+pe);
	    			}else JOptionPane.showMessageDialog(null, "There is no shape with the id "+id);
	    		}
	    	}
	    });
	    
	    delete.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		if (shapes.size() == 0) JOptionPane.showMessageDialog(null, "There are currently no shapes stored.");
	    		else{
	    			String id = shapeId.getText();
	    			if (containsShape(id)){
	    				int j = findShape(id);
	    				shapes.remove(j);
	    				updateList();
	    				a2.setText(id + " was deleted.");
	    			}else JOptionPane.showMessageDialog(null, "There is no shape with the id "+id);
	    		}
	    	}
	    });
	    
	    update.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		if (shapes.size() == 0) JOptionPane.showMessageDialog(null, "There are currently no shapes stored.");
	    		else{
	    			String id = shapeId.getText();
	    			if (containsShape(id)){
	    				submit.setVisible(false);
	    				resubmit.setVisible(true);
	    				rPoint.setEnabled(false);
	    				rLine.setEnabled(false);
	    				rEllipse.setEnabled(false);
	    				rCircle.setEnabled(false);
	    				rRectangle.setEnabled(false);
	    				rSquare.setEnabled(false);
	    				rTriangle.setEnabled(false);
	    				shapeId.setEditable(false);
	    				area.setEnabled(false);
	    				perimeter.setEnabled(false);
	    				delete.setEnabled(false);
	    				update.setEnabled(false);
	    				throwDart.setEnabled(false);
	    				dx.setEditable(false);
	    				dy.setEditable(false);
	    				
	    				int j = findShape(id);
	    				Shape s = shapes.get(j);
	    				if (s instanceof Point) setPointOptions();
	    				else if (s instanceof Line) setLineOptions();
	    				else if (s instanceof Circle) setCircleOptions();
	    				else if (s instanceof Ellipse) setEllipseOptions();
	    				else if (s instanceof Rectangle) setRectangleOptions();
	    				else if (s instanceof Triangle) setTriangleOptions();
	    			}else JOptionPane.showMessageDialog(null, "There is no shape with the id "+id);
	    		}
	    	}
	    });
	    
	    resubmit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		submit.setVisible(true);
				resubmit.setVisible(false);
				rPoint.setEnabled(true);
				rLine.setEnabled(true);
				rEllipse.setEnabled(true);
				rCircle.setEnabled(true);
				rRectangle.setEnabled(true);
				rSquare.setEnabled(true);
				rTriangle.setEnabled(true);
				shapeId.setEditable(true);
				area.setEnabled(true);
				perimeter.setEnabled(true);
				delete.setEnabled(true);
				update.setEnabled(true);
				throwDart.setEnabled(true);
				dx.setEditable(true);
				dy.setEditable(true);
				
				String id = shapeId.getText();
				int j = findShape(id);
				Shape s = shapes.get(j);
				if (s instanceof Point) updatePoint(j);
				else if (s instanceof Line) updateLine(j);
				else if (s instanceof Circle) updateCircle(j);
				else if (s instanceof Ellipse) updateEllipse(j);
				else if (s instanceof Square) updateSquare(j);
				else if (s instanceof Rectangle) updateRectangle(j);
				else if (s instanceof Triangle) updateTriangle(j);
				
				if (rPoint.isSelected()) setPointOptions();
	    		else if (rLine.isSelected()) setLineOptions();
	    		else if (rEllipse.isSelected()) setEllipseOptions();
	    		else if (rCircle.isSelected()) setCircleOptions();
	    		else if (rRectangle.isSelected() || rSquare.isSelected()) setRectangleOptions();
	    		else if (rTriangle.isSelected()) setTriangleOptions();
	    	}
	    });
	    
	    throwDart.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		if (shapes.size() == 0) JOptionPane.showMessageDialog(null, "There are currently no shapes stored.");
	    		else{
	    			String dartx = dx.getText();
	    			String darty = dy.getText();
	    			if (isDouble(dartx) && isDouble(darty)){
	    				double x = Double.parseDouble(dartx);
	    				double y = Double.parseDouble(darty);
	    				
	    				Point p = null;
	    				try {
	    					a2.setText("You hit: \n");
	    					p = new Point(x,y);
	    					int hit=0;
	    					for (int i=0;i<shapes.size();i++){
	    						if (shapes.get(i).hit(p)){
	    							hit++;
	    							a2.append(shapes.get(i).toString() + "\n");
	    						}
	    					}
	    					
	    					if (hit==0) a2.append("Nothing.");
	    					
	    				} catch (OutOfBoundsException e) {
	    					JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
	    				}
	    			}else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	    		}
	    	}
	    });
	}
	
	public boolean isDouble(String s){
		return (s.matches("[0-9]{1,13}(\\.[0-9]*)?"));
	}
	
	public boolean containsShape(String s){
		for (int i=0;i<shapes.size();i++){
			String temp = shapes.get(i).id();
			if (temp.matches(s)) return true;
		}
		return false;
	}
	
	public int findShape(String s){
		for (int i=0;i<shapes.size();i++){
			String temp = shapes.get(i).id();
			if (temp.matches(s)) return i;
		}
		return -1;
	}
	
	public void setPointOptions(){
		p1xLabel.setText("X:");
    	p1yLabel.setText("Y:");
    	p2xLabel.setVisible(false);
 	    p2x.setVisible(false);
 	    p2yLabel.setVisible(false);
 	    p2y.setVisible(false);
 	    p3xLabel.setVisible(false);
 	    p3x.setVisible(false);
 	    p3yLabel.setVisible(false);
 	    p3y.setVisible(false);
 	    p1x.setText("");
	    p1y.setText("");
	}
	
	public void setLineOptions(){
		p1xLabel.setText("Point 1)  X:");
    	p1yLabel.setText("Y:");
    	p2xLabel.setVisible(true);
 	    p2x.setVisible(true);
 	    p2yLabel.setVisible(true);
 	    p2y.setVisible(true);
 	    p2xLabel.setText("Point 2)  X:");
 	    p2yLabel.setText("Y:");
 	    p3xLabel.setVisible(false);
 	    p3x.setVisible(false);
 	    p3yLabel.setVisible(false);
 	    p3y.setVisible(false);
 	    p1x.setText("");
	    p1y.setText("");
	    p2x.setText("");
	    p2y.setText("");
	}
	
	public void setEllipseOptions(){
		p1xLabel.setText("Center Point)  X:");
    	p1yLabel.setText("Y:");
    	p2xLabel.setVisible(true);
 	    p2x.setVisible(true);
 	    p2yLabel.setVisible(true);
 	    p2y.setVisible(true);
 	    p2xLabel.setText("Vertical Radius: ");
 	    p2yLabel.setText("Horizontal Radius: ");
 	    p3xLabel.setVisible(false);
 	    p3x.setVisible(false);
 	    p3yLabel.setVisible(false);
 	    p3y.setVisible(false);
 	    p1x.setText("");
	    p1y.setText("");
	    p2x.setText("");
	    p2y.setText("");
	}
	
	public void setCircleOptions(){
		p1xLabel.setText("Center Point)  X:");
    	p1yLabel.setText("Y:");
    	p2xLabel.setVisible(true);
 	    p2x.setVisible(true);
 	    p2yLabel.setVisible(false);
 	    p2y.setVisible(false);
 	    p2xLabel.setText("Radius: ");
 	    p3xLabel.setVisible(false);
 	    p3x.setVisible(false);
 	    p3yLabel.setVisible(false);
 	    p3y.setVisible(false);
 	    p1x.setText("");
	    p1y.setText("");
	    p2x.setText("");
	}
	
	public void setRectangleOptions(){
		p1xLabel.setText("Upper Left Point)  X:");
    	p1yLabel.setText("Y:");
    	p2xLabel.setVisible(true);
 	    p2x.setVisible(true);
 	    p2yLabel.setVisible(true);
 	    p2y.setVisible(true);
 	    p2xLabel.setText("Lower Right Point)  X:");
 	    p2yLabel.setText("Y:");
 	    p3xLabel.setVisible(false);
 	    p3x.setVisible(false);
 	    p3yLabel.setVisible(false);
 	    p3y.setVisible(false);
 	    p1x.setText("");
	    p1y.setText("");
	    p2x.setText("");
	    p2y.setText("");
	}
	
	public void setTriangleOptions(){
		p1xLabel.setText("Point 1)  X:");
    	p1yLabel.setText("Y:");
    	p2xLabel.setVisible(true);
 	    p2x.setVisible(true);
 	    p2yLabel.setVisible(true);
 	    p2y.setVisible(true);
 	    p2xLabel.setText("Point 2)  X:");
 	    p2yLabel.setText("Y:");
 	    p3xLabel.setVisible(true);
 	    p3x.setVisible(true);
 	    p3yLabel.setVisible(true);
 	    p3y.setVisible(true);
 	    p3xLabel.setText("Point 3)  X:");
 	    p3yLabel.setText("Y:");
 	    p1x.setText("");
 	    p1y.setText("");
 	    p2x.setText("");
	    p2y.setText("");
	    p3x.setText("");
 	    p3y.setText("");
	}
	
	public void updateList(){
		a.setText("");
		for (int i=0;i<shapes.size();i++){
			String temp = shapes.get(i).toString() + "\n";
			a.append(temp);
		}
	}
	
	public void createPoint(){
		String px = p1x.getText();
		String py = p1y.getText();
		
		if (isDouble(px) && isDouble(py)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			
			Point p = null;
			try {
				int pid = pCount.incrementAndGet();
				p = new Point(x,y,pid);
				shapes.add(p);
				updateList();
				a2.setText(p.id() + " was created");
			} catch (OutOfBoundsException e) {
				pCount.decrementAndGet();
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void createLine(){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double x2 = Double.parseDouble(px2);
			double y2 = Double.parseDouble(py2);
			
			Point p = null;
			Point p2 = null;
			Line l = null;
			try {
				int lid = lCount.incrementAndGet();
				p = new Point(x,y);
				p2 = new Point(x2,y2);
				l = new Line(p,p2,lid);
				shapes.add(l);
				updateList();
				a2.setText(l.id() + " was created");
			} catch (OutOfBoundsException e) {
				lCount.decrementAndGet();
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			} catch (InvalidArgumentException e) {
				lCount.decrementAndGet();
				JOptionPane.showMessageDialog(null,  "Please enter the leftmost point of the line," +
						"then the rightmost point of the line.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void createEllipse(){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double vr = Double.parseDouble(px2);
			double vh = Double.parseDouble(py2);
			
			Point p = null;
			Ellipse el = null;
			try {
				int eid = eCount.incrementAndGet();
				p = new Point(x,y);
				el = new Ellipse(p,vr,vh,eid);
				shapes.add(el);
				updateList();
				a2.setText(el.id() + " was created");
			} catch (OutOfBoundsException e) {
				eCount.decrementAndGet();
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void createCircle(){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double r = Double.parseDouble(px2);
			
			Point p = null;
			Circle c = null;
			try {
				int cid = cCount.incrementAndGet();
				p = new Point(x,y);
				c = new Circle(p,r,cid);
				shapes.add(c);
				updateList();
				a2.setText(c.id() + " was created");
			} catch (OutOfBoundsException e) {
				cCount.decrementAndGet();
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void createRectangle(){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double x2 = Double.parseDouble(px2);
			double y2 = Double.parseDouble(py2);
			
			Point p = null;
			Point p2 = null;
			Rectangle r = null;
			try {
				int rid = rCount.incrementAndGet();
				p = new Point(x,y);
				p2 = new Point(x2,y2);
				r = new Rectangle(p,p2,rid);
				shapes.add(r);
				updateList();
				a2.setText(r.id() + " was created");
			} catch (OutOfBoundsException e) {
				rCount.decrementAndGet();
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			} catch (InvalidArgumentException e) {
				rCount.decrementAndGet();
				JOptionPane.showMessageDialog(null,  "Please enter the upper left point of the rectangle," +
						" then the bottom right point of the rectangle.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void createSquare(){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double x2 = Double.parseDouble(px2);
			double y2 = Double.parseDouble(py2);
			
			Point p = null;
			Point p2 = null;
			Square s = null;
			try {
				int sid = sCount.incrementAndGet();
				p = new Point(x,y);
				p2 = new Point(x2,y2);
				s = new Square(p,p2,sid);
				shapes.add(s);
				updateList();
				a2.setText(s.id() + " was created");
			} catch (OutOfBoundsException e) {
				sCount.decrementAndGet();
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			} catch (InvalidArgumentException e) {
				sCount.decrementAndGet();
				JOptionPane.showMessageDialog(null,  "Please enter the upper left point of the square," +
						" then the bottom right point of the square.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void createTriangle(){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		String px3 = p3x.getText();
		String py3 = p3y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2) && isDouble(px3) && isDouble(py3)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double x2 = Double.parseDouble(px2);
			double y2 = Double.parseDouble(py2);
			double x3 = Double.parseDouble(px3);
			double y3 = Double.parseDouble(py3);
			
			Point p = null;
			Point p2 = null;
			Point p3 = null;
			Triangle t = null;
			try {
				int tid = tCount.incrementAndGet();
				p = new Point(x,y);
				p2 = new Point(x2,y2);
				p3 = new Point(x3,y3);
				t = new Triangle(p,p2,p3,tid);
				shapes.add(t);
				updateList();
				a2.setText(t.id() + " was created");
			} catch (OutOfBoundsException e) {
				tCount.decrementAndGet();
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			} catch (InvalidArgumentException e) {
				tCount.decrementAndGet();
				JOptionPane.showMessageDialog(null,  "Please enter three points that are" +
						" not overlapping or colinear.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void updatePoint(int j){
		String px = p1x.getText();
		String py = p1y.getText();
		
		if (isDouble(px) && isDouble(py)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			
			Point p = null;
			Point oldP = (Point) shapes.get(j);
			int pid = oldP.getIdNum();
			try {
				p = new Point(x,y,pid);
				shapes.set(j,p);
				updateList();
				a2.setText(oldP.id() + " was updated.");
			} catch (OutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void updateLine(int j){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double x2 = Double.parseDouble(px2);
			double y2 = Double.parseDouble(py2);
			
			Point p = null;
			Point p2 = null;
			Line l = null;
			Line oldL = (Line) shapes.get(j);
			int lid = oldL.getIdNum();
			try {
				p = new Point(x,y);
				p2 = new Point(x2,y2);
				l = new Line(p,p2,lid);
				shapes.set(j,l);
				updateList();
				a2.setText(oldL.id() + " was updated.");
			} catch (OutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			} catch (InvalidArgumentException e) {
				JOptionPane.showMessageDialog(null,  "Please enter the leftmost point of the line," +
						"then the rightmost point of the line.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void updateEllipse(int j){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double vr = Double.parseDouble(px2);
			double vh = Double.parseDouble(py2);
			
			Point p = null;
			Ellipse el = null;
			Ellipse oldE = (Ellipse) shapes.get(j);
			int eid = oldE.getIdNum();
			try {
				p = new Point(x,y);
				el = new Ellipse(p,vr,vh,eid);
				shapes.set(j,el);
				updateList();
				a2.setText(oldE.id() + " was updated.");
			} catch (OutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void updateCircle(int j){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double r = Double.parseDouble(px2);
			
			Point p = null;
			Circle c = null;
			Circle oldC = (Circle) shapes.get(j);
			int cid = oldC.getIdNum();
			try {
				p = new Point(x,y);
				c = new Circle(p,r,cid);
				shapes.set(j,c);
				updateList();
				a2.setText(oldC.id() + " was updated.");
			} catch (OutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void updateRectangle(int j){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double x2 = Double.parseDouble(px2);
			double y2 = Double.parseDouble(py2);
			
			Point p = null;
			Point p2 = null;
			Rectangle r = null;
			Rectangle oldR = (Rectangle) shapes.get(j);
			int rid = oldR.getIdNum();
			try {
				p = new Point(x,y);
				p2 = new Point(x2,y2);
				r = new Rectangle(p,p2,rid);
				shapes.set(j,r);
				updateList();
				a2.setText(oldR.id() + " was updated.");
			} catch (OutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			} catch (InvalidArgumentException e) {
				JOptionPane.showMessageDialog(null,  "Please enter the upper left point of the rectangle," +
						" then the bottom right point of the rectangle.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void updateSquare(int j){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double x2 = Double.parseDouble(px2);
			double y2 = Double.parseDouble(py2);
			
			Point p = null;
			Point p2 = null;
			Square s = null;
			Square oldS = (Square) shapes.get(j);
			int sid = oldS.getIdNum();
			try {
				p = new Point(x,y);
				p2 = new Point(x2,y2);
				s = new Square(p,p2,sid);
				shapes.set(j,s);
				updateList();
				a2.setText(oldS.id() + " was updated.");
			} catch (OutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			} catch (InvalidArgumentException e) {
				JOptionPane.showMessageDialog(null,  "Please enter the upper left point of the square," +
						" then the bottom right point of the square.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public void updateTriangle(int j){
		String px = p1x.getText();
		String py = p1y.getText();
		String px2 = p2x.getText();
		String py2 = p2y.getText();
		String px3 = p3x.getText();
		String py3 = p3y.getText();
		
		if (isDouble(px) && isDouble(py) && isDouble(px2) && isDouble(py2) && isDouble(px3) && isDouble(py3)){
			double x = Double.parseDouble(px);
			double y = Double.parseDouble(py);
			double x2 = Double.parseDouble(px2);
			double y2 = Double.parseDouble(py2);
			double x3 = Double.parseDouble(px3);
			double y3 = Double.parseDouble(py3);
			
			Point p = null;
			Point p2 = null;
			Point p3 = null;
			Triangle t = null;
			Triangle oldT = (Triangle) shapes.get(j);
			int tid = oldT.getIdNum();
			try {
				p = new Point(x,y);
				p2 = new Point(x2,y2);
				p3 = new Point(x3,y3);
				t = new Triangle(p,p2,p3,tid);
				shapes.set(j,t);
				updateList();
				a2.setText(oldT.id() + " was updated.");
			} catch (OutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Coordinates must be between 0 and 20.");
			} catch (InvalidArgumentException e) {
				JOptionPane.showMessageDialog(null,  "Please enter three points that are" +
						" not overlapping or colinear.");
			}
		} else JOptionPane.showMessageDialog(null, "Coordinates must be nonnegative numbers.");
	}
	
	public static void main(String args[]){
		new ShapeLand();
	}

}
