package panel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TextArea extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private int totalAmount = 0;

    public TextArea() {
        setLayout(new BorderLayout());

        // 테이블 모델 생성
        tableModel = new DefaultTableModel();
        tableModel.addColumn("상품명");
        tableModel.addColumn("단가");
        tableModel.addColumn("수량");
        tableModel.addColumn("합계");

        // JTable 생성
        table = new JTable(tableModel);
        table.setBackground(Color.white);
        Font koreanFont = new Font("NanumGothic", Font.PLAIN, 12);
        table.setFont(koreanFont);

        // 테이블을 JScrollPane에 넣어 스크롤 가능하도록 함
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 200)); // 크기 조절 가능

        add(scrollPane, BorderLayout.CENTER);
    }
    public void updateTotalAmount(int amount) {
        totalAmount += amount;
        // 합계를 JLabel 또는 다른 방법으로 표시하려면 이 곳에서 처리 가능
        System.out.println("총 합계: " + totalAmount);
    }

    public void addData(Object[] rowData) {
        tableModel.addRow(rowData);
        updateTotalAmount((int) rowData[3]);
    }
}