package kr.or.dgit.book_project.book_panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kr.or.dgit.book_project.basic_panel.BookCodePanel;
import kr.or.dgit.book_project.basic_panel.ComboBoxPanel;
import kr.or.dgit.book_project.basic_panel.InputComp;
import kr.or.dgit.book_project.basic_panel.SpinnerPanel;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.PublisherInfoService;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class BookInfo extends JPanel {
	protected JTextField tfAddPublisher;
	protected JButton btnBookSearch;
	protected JButton btnAddPublisher;
	private BookCodePanel pBCode;
	private InputComp pAuthor;
	private InputComp pBName;
	private SpinnerPanel pPrice;
	protected ComboBoxPanel pPublisher;

	public BookInfo() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(5, 2, 0, 10));

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 1, 5, 0));
		
		pBCode = new BookCodePanel();
		GridBagLayout gbl_pBCode = (GridBagLayout) pBCode.getLayout();
		gbl_pBCode.columnWidths = new int[] {120, 200, 0};
		panel_7.add(pBCode);

		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 5, 0));

		btnBookSearch = new JButton("도서검색");
		panel_6.add(btnBookSearch);
		
		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		pBName = new InputComp();
		pBName.setTitle("도  서  명");
		panel_3.add(pBName);

		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));

		pAuthor = new InputComp();
		pAuthor.setTitle("저       자");
		panel_4.add(pAuthor);

		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));

		pPrice = new SpinnerPanel();
		pPrice.setValues(0, 0, 500000, 100);
		pPrice.setTitle("가       격");
		panel_5.add(pPrice);

		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 5, 0));

		PublisherInfoService pis = new PublisherInfoService();
		List<PublisherInfo> list = pis.selectByAll();
		pPublisher = new ComboBoxPanel();
		pPublisher.setComboDate(list);
		pPublisher.setTitle("출  판  사");
		panel_2.add(pPublisher);

		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 2, 5, 0));

		tfAddPublisher = new JTextField();
		panel_13.add(tfAddPublisher);
		tfAddPublisher.setColumns(10);

		btnAddPublisher = new JButton("추가");
		panel_13.add(btnAddPublisher);
		JLabel label = new JLabel("");

		JLabel label_1 = new JLabel("");

	}

	
	
	public JTextField getTfAddPublisher() {
		return tfAddPublisher;
	}

	public JButton getBtnBookSearch() {
		return btnBookSearch;
	}

	public JButton getBtnAddPublisher() {
		return btnAddPublisher;
	}
	
	public void setClear(){
		pBCode.setTfBCode("");
		pBCode.setTfBSubCode("");
		pBName.setTFValue("");
		pAuthor.setTFValue("");
		pPrice.setValue(0);
		pPublisher.setSelected(0);
	}
	
	public boolean isVaildCheck(){
		try {
			pBCode.isEmptyCheck();
			pBName.isEmptyCheck();
			pAuthor.isEmptyCheck();
			pBCode.isValidCheck();
			pBName.isValidCheck("[a-zA-Z가-힣]+", "한글 또는 영문만 가능");
			pAuthor.isValidCheck("[a-zA-Z가-힣]+", "한글 또는 영문만 가능");
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
			//e.printStackTrace();
		}
		
	}



	public ComboBoxPanel getpPublisher() {
		return pPublisher;
	}

}
