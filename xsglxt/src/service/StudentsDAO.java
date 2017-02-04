package service;
import entity.Students;
import java.util.List;


public interface StudentsDAO {
	//��ѯ����ѧ������
	public List<Students> queryAllStudents();
	//��ѯ����ѧ������
	public Students queryStudentsbySid(String sid);
	//���ѧ������
	public boolean addStudents(Students s);
	//�޸�ѧ������
	public boolean updateStudents(Students s);
	//ɾ��ѧ������
	public boolean deleteStudents(String sid);
}
