package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import domain.UserVO;

public class UserDAO {

	public static Long userId;
	public Connection connection; //���� ��ü
	public PreparedStatement preparedStatement; //���� ���� ��ü
	public ResultSet resultSet; //��� ���̺� ��ü
	
//	���̵� �ߺ��˻�
	public boolean checkId(String userIdentification) {
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		boolean result = false;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			result = resultSet.getInt(1) == 0;
			
		} catch (SQLException e) {
			System.out.println("checkId(String) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}
	
//	ȸ������
	public void insert(UserVO userVO) {
		 String queryForJoin = "INSERT INTO TBL_USER"
		            + "(USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, USER_PHONE, USER_BIRTH, USER_EMAIL, USER_ADDRESS, USER_RECOMMENDER_ID) "
		            + "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";
		 
//		 ���� ���̺��� ��õ�� �÷��� �߰��Ͽ�, ȸ�� ���� ��ȸ �� ��õ ���� ���� ���������� ����
//		 String queryForUpdateRecommendCount = 
//				 "UPDATE TBL_USER SET RECOMMEND_COUNT = RECOMMEND_COUNT + 1 WHERE USER_ID = ?";
		 
//		 ���� ��õ �� ��ȸ�� ���� ���, ���̺��� ���� �и��Ͽ� ����Ű�� ������ �� ��ȸ
//		 ���̺��� �и��Ǿ ȸ������ �� TBL_USER�� INSERT �� TBL_RECOMMEND�� ���� INSERT�� �ʿ��ϴ�.
//		 �� �� TRIGGER�� ����Ͽ� TBL_USER�� INSERT�̺�Ʈ �߻� �� TBL_RECOMMEND���� �ڵ����� INSERT �ǵ��� ����
		 String queryForUpdateRecommendCount = 
				 "UPDATE TBL_RECOMMEND SET RECOMMEND_COUNT = RECOMMEND_COUNT + 1 WHERE USER_ID = ?";
		 
		 String queryForGetUserId = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		 
		 connection = DBConnecter.getConnection();
		 try {
			preparedStatement = connection.prepareStatement(queryForJoin);
			preparedStatement = connection.prepareStatement(queryForJoin);
			preparedStatement.setString(1, userVO.getUserIdentification());
			preparedStatement.setString(2, userVO.getUserName());
			preparedStatement.setString(3, encrypt(userVO.getUserPassword()));
			preparedStatement.setString(4, userVO.getUserPhone());
			preparedStatement.setString(5, userVO.getUserBirth());
			preparedStatement.setString(6, userVO.getUserEmail());
			preparedStatement.setString(7, userVO.getUserAddress());
			preparedStatement.setString(8, userVO.getUserRecommenderId());
			preparedStatement.executeUpdate();
			
			if(userVO.getUserRecommenderId() != null) {
				preparedStatement = connection.prepareStatement(queryForGetUserId);
				preparedStatement.setString(1, userVO.getUserRecommenderId());
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) { // �Է��� ��õ�� ���̵� ������ ���
					preparedStatement = connection.prepareStatement(queryForUpdateRecommendCount);
					preparedStatement.setLong(1, resultSet.getLong(1));
					preparedStatement.executeUpdate();
				}
			}

		} catch (SQLException e) {
			System.out.println("insert(UserVO) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
//	�α���
	public boolean login(String userIdentification, String userPassword) {
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		boolean check = false;
		
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			preparedStatement.setString(2, encrypt(userPassword));
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userId = resultSet.getLong(1);
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("login(String, String) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}
	
//	ȸ��Ż��
	public void delete() {
		String query = "DELETE FROM TBL_USER WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete() SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
//	���̵� ã��
	public String findIdentification(String userPhone) {
		String query = "SELECT USER_IDENTIFICATION FROM TBL_USER WHERE USER_PHONE = ?";
		String userIdentification = null;
		
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhone);

			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userIdentification = resultSet.getString(1);
			}
			
		} catch (SQLException e) {
			System.out.println("findIdentification(String) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return userIdentification;
	}
	
//	��й�ȣ ����
	public void updateUserPassword(String userPassword) {
		String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, new String(Base64.getEncoder().encode(userPassword.getBytes())));
			preparedStatement.setLong(2, userId);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateUserPassword(String) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
//	ȸ������ ����
	public void update(UserVO userVO) {
		String query = "UPDATE TBL_USER SET USER_NICKNAME = ?, USER_GENDER = ?, USER_BIRTH = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserNickname());
			preparedStatement.setString(2, userVO.getUserGender());
			preparedStatement.setString(3, userVO.getUserBirth());
			preparedStatement.setLong(4, userId);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("update(UserVO) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
//	ȸ������ ��ȸ
	public UserVO select(/* Long userId */) {
		String query = 
				"SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER WHERE USER_ID = ?";
		UserVO userVO = null;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
			}
			
		} catch (SQLException e) {
			System.out.println("select(Long) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return userVO;
	}
	
	public UserVO select(Long userId) {
		String query = 
				"SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
						+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
						+ "USER_GENDER, USER_RECOMMENDER_ID "
						+ "FROM TBL_USER WHERE USER_ID = ?";
		UserVO userVO = null;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
			}
			
		} catch (SQLException e) {
			System.out.println("select(Long) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return userVO;
	}
	
	public UserVO select(String userIdentification) {
		String query = 
				"SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
						+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
						+ "USER_GENDER, USER_RECOMMENDER_ID "
						+ "FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		UserVO userVO = null;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
			}
			
		} catch (SQLException e) {
			System.out.println("select(Long) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return userVO;
	}
	
//	��õ��
	public Long getCountOfRecommenderId(String userIdentification) {
//		String query = "SELECT RECOMMEND_COUNT FROM TBL_USER WHERE USER_ID = ?";
		String query = "SELECT RECOMMEND_COUNT FROM TBL_RECOMMEND WHERE USER_ID = ?";
		Long recommendCount = 0L;
		Long userId = select(userIdentification).getUserId();
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				recommendCount = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			System.out.println("getCountOfRecommenderId(Long) SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return recommendCount;
	}
	
//	���� ��õ�� ���
	public ArrayList<UserVO> selectRecommenders(){
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_RECOMMENDER_ID = ?";
		String userIdentification = select(userId).getUserIdentification();
		UserVO userVO = null;
		ArrayList<UserVO> users = new ArrayList<UserVO>();
		
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
				users.add(userVO);
			}
			
		} catch (SQLException e) {
			System.out.println("selectRecommenders() SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return users;
	}
	
//	���� ��õ�� ���
	public UserVO getMyRecommender() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = "
				+ "("
				+ "SELECT USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_ID = ?"
				+ ")";
		UserVO userVO = null;
		
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
			}
			
		} catch (SQLException e) {
			System.out.println("getMyRecommender() SQL�� ����");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return userVO;
	}
	
	public String encrypt(String password) {
		return new String(Base64.getEncoder().encode(password.getBytes()));
	}
	
}





















