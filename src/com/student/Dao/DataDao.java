package com.student.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.student.Dao.RegisterDAO;
import com.student.Dao.DataDao;
import com.student.FormBean.DataFormBean;

import com.student.Db.ConnectionFactory;

import com.student.Util.DateWrapper;

public class DataDao {

	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3, pstmt4, pstmt5, pstmt6,
			pstmt7, pstmt8, pstmt9, ps;
	Statement stmt, statement, stmt1;
	ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11,
			rs12, rs13, rs14;
	Connection con;
	String path = "";
	int dataid = 0;

	public DataDao() {

		con = ConnectionFactory.getConnection();

	}

	public boolean UploadData(DataFormBean wf) {
		int i = 0;
		String upfile = wf.getUpfile();
		boolean flag = false;
		try {

			pstmt = con
					.prepareStatement("insert into serverdata values((select nvl(max(docid),100)+1 from serverdata),?,?,?,?,?,?,?,?,sysdate)");

			pstmt.setString(1, wf.getDoc());
			pstmt.setString(2, wf.getUrl());
			pstmt.setString(3, wf.getContent());
			pstmt.setString(4, wf.getLocation());
			pstmt.setString(5, wf.getFilename());
			pstmt.setString(6, wf.getFilepath());
			File file4 = new File(upfile);
			FileInputStream fis4 = new FileInputStream(file4);
			pstmt.setBinaryStream(7, fis4, (int) file4.length());
			pstmt.setString(8, wf.getData());
			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (con != null) {

					con.close();

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}

	public List<String> collectData() {
		String name = null;
		String data = null;
		List<String> list = new ArrayList<String>();
		try {
			pstmt = con
					.prepareStatement("select distinct superdata from metadata");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);

				list.add(name);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Set<String> collectData1(String data) {
		String name = null;
		String name1 = null;

		Set<String> list = new HashSet<String>();
		try {
			System.out.println(data);
			pstmt = con.prepareStatement("select word from userselectword");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);

				System.out.println("match word===" + name);
				pstmt1 = con
						.prepareStatement("select subdata from metadata where UPPER(superdata)=UPPER('"
								+ data + "')");
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					name1 = rs1.getString(1);

					System.out.println("match word===" + name1);
					if (name.equalsIgnoreCase(name1)) {

						list.add(name);
					}
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public int collectData2(String data) {
		String name = null;
		int i = 0;
		int count = 0;
		try {
			System.out.println(data);

			// pstmt2=con.prepareStatement("truncate table count");
			// i=pstmt2.executeUpdate();
			pstmt = con
					.prepareStatement("select count(subdata) from userselectword where UPPER(word)=UPPER('"
							+ data + "')");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
				System.out.println(count);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public int collectData5(String data, String data1) {
		String name = null;
		int i = 0;
		int count = 0;
		try {
			System.out.println(data);

			pstmt = con
					.prepareStatement("select count(subdata) from userselectword where UPPER(word)=UPPER('"
							+ data + "')");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
				System.out.println(count);

				pstmt1 = con
						.prepareStatement("insert into calculation values(?,?,?)");
				pstmt1.setString(1, data1);
				pstmt1.setString(2, data);
				pstmt1.setInt(3, count);

				i = pstmt1.executeUpdate();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public ArrayList<DataFormBean> collectData3() {
		String name = null;
		String word = null;
		int count = 0;
		int i = 0;
		ArrayList<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			pstmt = con
					.prepareStatement("select distinct username,word from userselectword order by username");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DataFormBean d = new DataFormBean();

				name = rs.getString(1);
				d.setUsername(name);
				word = rs.getString(2);
				d.setSubdata(word);

				pstmt1 = con
						.prepareStatement("select count(word) from userselectword where UPPER(word)=UPPER('"
								+ word + "')");
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					count = rs1.getInt(1);
					System.out.println(count);

				}
				d.setCount(count);

				list.add(d);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public boolean insetDetails(int docid, String loginid, String query) {
		int i = 0;

		boolean flag = false;
		try {

			pstmt = con
					.prepareStatement("insert into selectdata values((select nvl(max(sno),100)+1 from selectdata),?,?,?)");
			pstmt.setInt(1, docid);
			pstmt.setString(2, loginid);
			pstmt.setString(3, query);

			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (con != null) {

					con.close();

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}

	public boolean insetmeatadata(DataFormBean wb) {
		int i = 0;

		boolean flag = false;
		try {

			pstmt = con
					.prepareStatement("insert into metadata values((select nvl(max(id),100)+1 from metadata),?,?)");

			pstmt.setString(1, wb.getSuperdata());
			pstmt.setString(2, wb.getSubdata());

			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (con != null) {

					con.close();

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}

	public boolean insetWord(String loginid, String word, String subdata) {
		int i = 0;

		boolean flag = false;
		try {

			pstmt = con
					.prepareStatement("insert into userselectword values((select nvl(max(sno),100)+1 from userselectword),?,?,?)");

			pstmt.setString(1, loginid);
			pstmt.setString(2, word);
			pstmt.setString(3, subdata);

			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (con != null) {

					con.close();

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;

	}

	public boolean deleteData(int dataid) {

		boolean flag = false;

		try {

			pstmt = con
					.prepareStatement("delete from serverdata where docid=?");

			pstmt.setInt(1, dataid);

			int delete = pstmt.executeUpdate();

			if (delete > 0) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
			}
		} catch (SQLException e) {
			// logger.error(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				// logger.error(e);
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {

				// logger.error(e);
			}
		}
		return flag;

	}

	public int getCalculation1() {

		int count = 0;
		try {

			pstmt = con.prepareStatement("select sum(count) from calculation");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
				System.out.println(count);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public ArrayList<DataFormBean> getCalculation() {

		ArrayList<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			ps = con
					.prepareStatement("select superdata,sum(count) from calculation group by superdata order by sum(count) desc ");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);
				f.setSuperdata(rs.getString(1));
				f.setCount(rs.getInt(2));

				list.add(f);

			}
			System.out.println("no of result set values" + list.size());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public ArrayList<DataFormBean> getServerData() {

		ArrayList<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			ps = con
					.prepareStatement("select docid,doc,url,content,location,filepath,FILEDATA from serverdata");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				f.setDataid(rs.getInt(1));
				f.setDoc(rs.getString(2));
				f.setUrl(rs.getString(3));
				f.setContent(rs.getString(4));
				f.setLocation(rs.getString(5));
				f.setFilepath(rs.getString(6));
				f.setData1(rs.getString(7));
				System.out.println(rs.getString(7));
				list.add(f);

			}
			System.out.println("no of result set values" + list.size());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public String getWordData(DataFormBean b) throws ZipException, IOException,
			SAXException, ParserConfigurationException {

		System.out.println(" I AM IN DAOIMPL");
		String data = "";
		try {
			File myFile = new File(b.getUpfile());
			List<String> lines = new ArrayList<String>();

			ZipFile docxFile = new ZipFile(myFile);
			ZipEntry documentXML = docxFile.getEntry("word/document.xml");
			InputStream documentXMLIS = docxFile.getInputStream(documentXML);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			Document doc = dbf.newDocumentBuilder().parse(documentXMLIS);

			Element tElement = doc.getDocumentElement();
			NodeList n = (NodeList) tElement.getElementsByTagName("w:p");
			String s = "";
			for (int j = 0; j < n.getLength(); j++) {

				Node child = n.item(j);
				String line = child.getTextContent();
				data = data + line;

				if (line != null && !line.trim().isEmpty()) {

					lines.add(line.trim());

				}

			}
			System.out.println(" ---------->>> Woord document  in daoimpl"
					+ data);

		} catch (Exception e) {
			e.getStackTrace();
		}

		return data;
	}

	public boolean SetValue(int dataid, int count) {
		int i = 0;

		boolean flag = false;
		try {

			pstmt = con.prepareStatement("insert into COUNTVALUE values(?,?)");

			pstmt.setInt(1, dataid);
			pstmt.setInt(2, count);

			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean DeleteCalculation() {
		int i = 0;

		boolean flag = false;
		try {

			pstmt = con.prepareStatement("truncate table calculation");

			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean DeleteValue() {
		int i = 0;

		boolean flag = false;
		try {

			pstmt = con.prepareStatement("truncate table countvalue");

			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean CountData(DataFormBean sf) {
		int i = 0;

		boolean flag = false;
		try {

			pstmt = con
					.prepareStatement("insert into countdata values(?,?,?,?,?)");

			pstmt.setInt(1, sf.getDataid());
			pstmt.setInt(2, sf.getCountdata());
			pstmt.setDouble(3, sf.getTf());
			pstmt.setDouble(4, sf.getIdf());
			pstmt.setDouble(5, sf.getTotal());

			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (con != null) {

					con.close();

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean CountTFData(DataFormBean sf) {
		int i = 0;

		boolean flag = false;
		try {

			pstmt = con.prepareStatement("insert into TFDATA values((?,?,?)");

			pstmt.setInt(1, sf.getDataid());
			pstmt.setDouble(2, sf.getTf());
			pstmt.setDouble(3, sf.getIdf());
			i = pstmt.executeUpdate();

			if (i > 0) {

				flag = true;
				con.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (con != null) {

					con.close();

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public ArrayList<DataFormBean> getDatas(String query) {

		ArrayList<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			ps = con
					.prepareStatement("select docid,doc,url,content,location,filepath,FILEDATA from serverdata where UPPER(url) LIKE UPPER('%"
							+ query + "%') order by docid asc");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				f.setDataid(rs.getInt(1));
				f.setDoc(rs.getString(2));
				f.setUrl(rs.getString(3));
				f.setContent(rs.getString(4));
				f.setLocation(rs.getString(5));
				f.setFilepath(rs.getString(6));
				f.setData1(rs.getString(7));
				System.out.println(rs.getString(7));
				list.add(f);
				System.out.println("no of result set values" + list.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public ArrayList<DataFormBean> getDatas1(String query) {
		int count = 0;
		String data1 = null;
		String data3 = null;
		String data2 = null;
		ArrayList<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			pstmt = con
					.prepareStatement("select docid,doc,url,content,location,filepath,FILEDATA from serverdata where UPPER(url) LIKE UPPER('%"
							+ query + "%') order by docid asc");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				f.setDataid(rs.getInt(1));
				f.setDoc(rs.getString(2));
				f.setUrl(rs.getString(3));
				f.setContent(rs.getString(4));
				f.setLocation(rs.getString(5));
				f.setFilepath(rs.getString(6));
				f.setData1(rs.getString(7));
				String data = rs.getString(7);
				System.out.println(data);

				StringTokenizer st = new StringTokenizer(data);
				while (st.hasMoreTokens()) {
					data1 = st.nextToken();
					System.out.println(data1);
					pstmt2 = con
							.prepareStatement("select superdata from calculation group by superdata order by sum(count) desc ");
					rs2 = pstmt2.executeQuery();
					if (rs2.next()) {
						data2 = rs2.getString(1);
						pstmt1 = con
								.prepareStatement("select distinct subdata from calculation where UPPER(superdata)=UPPER('"
										+ data2 + "')");
						rs1 = pstmt1.executeQuery();
						while (rs1.next()) {
							data3 = rs1.getString(1);

							if (data1.equalsIgnoreCase(data3)) {
								System.out.println("match word===" + data3);
								count++;
							}
						}
						pstmt1.close();
					}pstmt2.close();
					
				}
				if (count > 7) {
					list.add(f);
				}
				System.out.println(count);
				
				System.out.println("no of result set values" + list.size());
			}

			count = 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public ArrayList<DataFormBean> getSelectDatas() {

		ArrayList<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			ps = con
					.prepareStatement("select d.docid,d.doc,d.content,d.location,d.FILEDATA,s.loginname,s.query from serverdata d,selectdata s where d.docid=s.dataid ");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				f.setDataid(rs.getInt(1));
				f.setDoc(rs.getString(2));
				f.setContent(rs.getString(3));
				f.setLocation(rs.getString(4));
				f.setData1(rs.getString(5));
				f.setQuery(rs.getString(7));
				f.setUsername(rs.getString(6));

				list.add(f);
				System.out.println("no of result set values" + list.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public List<DataFormBean> getTFvalue() {

		List<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			ps = con
					.prepareStatement("select distinct(dataid),round(tf,3),round(idf,3),round(total,3) from COUNTDATA");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				f.setDataid(rs.getInt(1));
				f.setTf(rs.getDouble(2));
				f.setIdf(rs.getDouble(3));
				f.setTotal(rs.getDouble(4));
				list.add(f);
				System.out.println("no of result set values" + list.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public List<DataFormBean> getGraphValue() {

		List<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			ps = con
					.prepareStatement("select slideNo,count,total from slideDATA");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				f.setSlideno(rs.getInt(1));
				f.setCount(rs.getInt(2));
				f.setTotal(rs.getDouble(3));
				list.add(f);
				System.out.println("no of result set values" + list.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public List<DataFormBean> getValue() {

		List<DataFormBean> list = new ArrayList<DataFormBean>();
		try {

			ps = con.prepareStatement("select dataid,count from countvalue");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				f.setDataid(rs.getInt(1));
				f.setCount(rs.getInt(2));

				list.add(f);
				System.out.println("no of result set values" + list.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public Vector<String> getValueData() {

		Vector<String> list = new Vector<String>();
		try {

			ps = con
					.prepareStatement("select distinct superdata from metadata");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				String data = rs.getString(1);

				list.add(data);
				System.out.println("no of result set values" + list.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public Vector<DataFormBean> getValueData1() {

		Vector<DataFormBean> list = new Vector<DataFormBean>();
		try {

			ps = con
					.prepareStatement("select  superdata,subdata from metadata");

			rs = ps.executeQuery();

			while (rs.next()) {
				DataFormBean f = new DataFormBean();
				System.out.println(f);

				f.setSuperdata(rs.getString(1));
				f.setSubdata(rs.getString(2));

				list.add(f);
				System.out.println("no of result set values" + list.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;

	}

	public String getContent(int dataid) {

		List<DataFormBean> list = null;
		try {

			ps = con.prepareStatement("select datas from datas where dataid=?");
			ps.setInt(1, dataid);
			rs1 = ps.executeQuery();
			if (rs1.next())
				return rs1.getString(1);
			// return resultSet.getString("datas");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			try {
				// ResourceHelper.closeConnection();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		return null;
	}

	public String getTitle(int dataid) {

		List<DataFormBean> list = null;
		try {

			ps = con.prepareStatement("select title from datas where dataid=?");
			ps.setInt(1, dataid);
			rs1 = ps.executeQuery();
			if (rs1.next())
				return rs1.getString(1);
			// return resultSet.getString("datas");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			try {
				// ResourceHelper.closeConnection();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
		return null;
	}
}
