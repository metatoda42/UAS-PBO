package tugasmvc;


import javax.swing.table.*;
import javax.swing.*;

public class View extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel panelutama = new JPanel();
	
	JLabel jlid = new JLabel("ID");
	JLabel jlnama = new JLabel("Nama");
	JLabel jlalamat = new JLabel("Alamat");
	JLabel jltelp = new JLabel("Nomor Telepon");
	JLabel jltl = new JLabel("Tanggal Lahir");
	JLabel jljekel = new JLabel("Jenis Kelamin");
	
	JTextField jtid = new JTextField();
	JTextField jtnama = new JTextField();
	JTextField jtalamat = new JTextField();
	JTextField jttelp = new JTextField();
	JTextField jttly = new JTextField();
	JTextField jttlm = new JTextField();
	JTextField jttld = new JTextField();
	JTextField jtcari = new JTextField();
	String[] jekel = {"L","P"};
	JComboBox<String> jcjekel = new JComboBox<String> ();
	
	JButton jbsave = new JButton("Save");
	JButton jbedit = new JButton("Edit");
	JButton jbdelete = new JButton("Delete");
	JButton jbtambah = new JButton("Tambah");
	JButton jbcari = new JButton("Cari");
	JButton jbreset = new JButton("Reset");
	
	JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Nama", "Alamat","No. Telepon", "Tanggal Lahir", "Jekel"};
	
    
    
	View(){
		dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        scrollPane.setBounds(262, 44, 622, 171);
		
		setTitle("Data Mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setLayout(null);
        setSize(910,311); // x , y
        panelutama.setBounds(0, 0, 894, 272);
        getContentPane().add(panelutama);
        panelutama.setLayout(null);
        jlid.setBounds(10, 44, 11, 14);
        
        panelutama.add(jlid);
        jtcari.setBounds(649, 231, 174, 20);
        
        panelutama.add(jtcari);
        jlnama.setBounds(10, 69, 27, 14);
        panelutama.add(jlnama);
        jlalamat.setBounds(10, 94, 33, 14);
        panelutama.add(jlalamat);
        jltelp.setBounds(10, 119, 72, 14);
        panelutama.add(jltelp);
        jltl.setBounds(10, 144, 64, 14);
        panelutama.add(jltl);
        jljekel.setBounds(10, 169, 63, 14);
        panelutama.add(jljekel);
        jtid.setBounds(94, 41, 158, 20);
        jtid.setEnabled(false);
        panelutama.add(jtid);
        jtnama.setBounds(94, 66, 158, 20);
        jtnama.setEnabled(false);
        panelutama.add(jtnama);
        jtalamat.setBounds(94, 91, 158, 20);
        jtalamat.setEnabled(false);
        panelutama.add(jtalamat);
        jttelp.setBounds(94, 116, 158, 20);
        jttelp.setEnabled(false);
        panelutama.add(jttelp);
        jttly.setToolTipText("Year");
        jttly.setBounds(180, 141, 72, 20);
        jttly.setEnabled(false);
        panelutama.add(jttly);
        jttlm.setToolTipText("MONTH");
        jttlm.setBounds(145, 141, 34, 20);
        jttlm.setEnabled(false);
        panelutama.add(jttlm);
        jttld.setToolTipText("DAY");
        jttld.setBounds(94, 141, 51, 20);
        jttld.setEnabled(false);
        panelutama.add(jttld);
        jcjekel.setBounds(94, 166, 158, 20);
        jcjekel.setModel(new DefaultComboBoxModel<String>(new String[] {"L", "P"}));
        jcjekel.setEnabled(false);
        panelutama.add(jcjekel);
        jbsave.setBounds(94, 197, 72, 20);
        
        panelutama.add(scrollPane);
        panelutama.add(jbsave);
        jbcari.setBounds(812, 231, 72, 20);
        panelutama.add(jbcari);
        jbedit.setBounds(165, 197, 87, 20);
        panelutama.add(jbedit);
        jbdelete.setBounds(79, 231, 87, 20);
        panelutama.add(jbdelete);
        jbtambah.setBounds(165, 231, 87, 20);
        panelutama.add(jbtambah);
        jbreset.setBounds(262, 231, 87, 20);
        panelutama.add(jbreset);
		
	}
	//GETTERS
	
	public int getID() {
		int fish = Integer.parseInt(jtid.getText());
		return fish;
	}
	
	public boolean cekID() {
		if(jtid.getText()=="")
			return false;
		else return true;
	}
	public String getNama() {
		return jtnama.getText();
	}
	public String getAlamat() {
		return jtalamat.getText();
	}
	public String getTelepon() {
		return jttelp.getText();
	}
	public String getTanggal() {
		String tanggal = jttly.getText()+"-"+jttlm.getText()+"-"+jttld.getText();
		return tanggal;
	}
	public String getJekel() {
		return (String) jcjekel.getSelectedItem();
	}
	
	public String getCari() {
		return jtcari.getText();
	}
	
	public void disableall() {
		jtid.setEnabled(false);
		jtnama.setEnabled(false);
		jtalamat.setEnabled(false);
		jttelp.setEnabled(false);
		jttld.setEnabled(false);
		jttlm.setEnabled(false);
		jttly.setEnabled(false);
		jcjekel.setEnabled(false);
	}
	public void enableall() {
		jtid.setEnabled(true);
		jtnama.setEnabled(true);
		jtalamat.setEnabled(true);
		jttelp.setEnabled(true);
		jttld.setEnabled(true);
		jttlm.setEnabled(true);
		jttly.setEnabled(true);
		jcjekel.setEnabled(true);
	}
	
	
	
	
	
	
	
}