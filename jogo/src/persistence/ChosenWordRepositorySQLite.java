package persistence;

import models.ChosenWord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import commons.Constants;

public class ChosenWordRepositorySQLite implements ChosenWordRepository {

	@Override
	public ChosenWord[] findBy(int id) {
		Connection con;
		PreparedStatement prepStmt;
		String sql = "SELECT * FROM Termo WHERE id = ? ";
		try{
			con = DriverManager.getConnection(Constants.URL);
			prepStmt = con.prepareStatement(sql);
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			int count = 0;
			
			while (rs.next()) {
				count++;
			}
			
			ChosenWord[] words = new ChosenWord[count];
			rs = prepStmt.executeQuery();
			int index = 0;
			
			while (rs.next()) {
				int cId = rs.getInt(id);
				String cWord = rs.getString("word");

				ChosenWord c = new ChosenWord(cId, cWord);
				words[index] = c;
				index++;
			}
			rs.close();
			prepStmt.close();
			con.close();

			return words;
		} catch (SQLException e) {
		e.printStackTrace();

		return new ChosenWord[0];
		}
	}
}