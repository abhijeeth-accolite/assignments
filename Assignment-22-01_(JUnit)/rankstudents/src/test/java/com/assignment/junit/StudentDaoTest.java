package com.assignment.junit;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kohsuke.randname.RandomNameGenerator;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class StudentDaoTest {
	public static final String STUDENT_CSV_FILE_PATH = "students.csv";
	public static final String MARK_CSV_FILE_PATH = "marks.csv";
	public static final String OUTPUT_CSV_FILE_PATH = "output.csv";
	public static final int STUDENT_COUNT = 200;
	public static final int MAX_STUDENT_ID = 99999;
	public static final int MAX_AGE = 100;
	public static final int MAX_SCORE = 100;
	static RandomNameGenerator randomNameGenerator;
	static Random random;
	static Map<Integer, Student> generatedStudents = new HashMap<Integer, Student>();

	@BeforeClass
	public static void randomlyGenerate() throws IOException {
		CSVWriter studentCSVWriter = new CSVWriter(new FileWriter(STUDENT_CSV_FILE_PATH));
		CSVWriter markCSVWriter = new CSVWriter(new FileWriter(MARK_CSV_FILE_PATH));
		randomNameGenerator = new RandomNameGenerator(0);
		random = new Random();
		for (int i = 0; i < 200; i++) {
			Student student = new Student(random.nextInt(MAX_STUDENT_ID + 1), randomNameGenerator.next(),
					random.nextInt(MAX_AGE + 1));
			generatedStudents.put(student.getStudentId(), student);
			studentCSVWriter.writeNext(student.getCSV());
			for (Subject subject : Subject.values()) {
				Mark mark = new Mark(student.getStudentId(), subject, random.nextInt(MAX_SCORE + 1));
				generatedStudents.get(student.getStudentId()).getStudentMarks().put(subject, mark);
				markCSVWriter.writeNext(mark.getCSV());
			}
		}
		markCSVWriter.close();
		studentCSVWriter.close();
	}

	@Test
	public void testStudentLoaderWithCorrectFile() throws IOException {
		StudentDao studentDao = new StudentDao();
		Map<Integer, Student> fetchedStudents = studentDao.loadStudents(STUDENT_CSV_FILE_PATH);
		assertEquals(fetchedStudents, generatedStudents);
	}

	@Test(expected = IOException.class)
	public void testStudentLoaderWithNoFile() throws IOException {
		StudentDao studentDao = new StudentDao();
		Map<Integer, Student> students = studentDao.loadStudents("wrong_file_name.csv");
	}

	@Test
	public void testMarksLoaderWithCorrectFile() throws IOException {
		StudentDao studentDao = new StudentDao();
		Map<Integer, Student> fetchedStudents = studentDao.loadStudents(STUDENT_CSV_FILE_PATH);
		studentDao.loadMarks(fetchedStudents, MARK_CSV_FILE_PATH);
		for (Student generatedStudent : generatedStudents.values()) {
			assertEquals(fetchedStudents.get(generatedStudent.getStudentId()).getStudentMarks(),
					generatedStudent.getStudentMarks());
		}

	}

	@Test(expected = IOException.class)
	public void testMarksLoaderWithNoFile() throws IOException {
		StudentDao studentDao = new StudentDao();
		Map<Integer, Student> students = studentDao.loadStudents(STUDENT_CSV_FILE_PATH);
		studentDao.loadMarks(students, "wrong_csv_file_path.csv");
	}

	@Test(expected = NullPointerException.class)
	public void testMarksLoaderWithNoStudents() throws IOException {
		StudentDao studentDao = new StudentDao();
		studentDao.loadMarks(null, MARK_CSV_FILE_PATH);
	}

	@Test
	public void testComparator() {
		Student s1 = new Student(1, "a", 5);
		s1.getStudentMarks().put(Subject.BIOLOGY, new Mark(1, Subject.BIOLOGY, 5));
		s1.getStudentMarks().put(Subject.CHEMISTRY, new Mark(1, Subject.CHEMISTRY, 5));
		s1.getStudentMarks().put(Subject.MATHS, new Mark(1, Subject.MATHS, 5));
		s1.getStudentMarks().put(Subject.PHYSICS, new Mark(1, Subject.PHYSICS, 5));
		s1.getStudentMarks().put(Subject.GEOGRAPHY, new Mark(1, Subject.GEOGRAPHY, 5));

		Student s2 = new Student(2, "b", 5);
		s2.getStudentMarks().put(Subject.BIOLOGY, new Mark(2, Subject.BIOLOGY, 6));
		s2.getStudentMarks().put(Subject.CHEMISTRY, new Mark(2, Subject.CHEMISTRY, 5));
		s2.getStudentMarks().put(Subject.MATHS, new Mark(2, Subject.MATHS, 5));
		s2.getStudentMarks().put(Subject.PHYSICS, new Mark(2, Subject.PHYSICS, 5));
		s2.getStudentMarks().put(Subject.GEOGRAPHY, new Mark(2, Subject.GEOGRAPHY, 5));

		Student s3 = new Student(3, "c", 5);
		s3.getStudentMarks().put(Subject.BIOLOGY, new Mark(2, Subject.BIOLOGY, 7));
		s3.getStudentMarks().put(Subject.CHEMISTRY, new Mark(2, Subject.CHEMISTRY, 5));
		s3.getStudentMarks().put(Subject.MATHS, new Mark(2, Subject.MATHS, 5));
		s3.getStudentMarks().put(Subject.PHYSICS, new Mark(2, Subject.PHYSICS, 5));
		s3.getStudentMarks().put(Subject.GEOGRAPHY, new Mark(2, Subject.GEOGRAPHY, 5));

		List<Student> sortedStudents = new ArrayList<Student>();
		sortedStudents.add(s1);
		sortedStudents.add(s2);
		sortedStudents.add(s3);

		List<Student> expectedStudents = new ArrayList<Student>();
		expectedStudents.add(s3);
		expectedStudents.add(s2);
		expectedStudents.add(s1);

		Collections.sort(sortedStudents, StudentDao.StudentRankComparator);
		assertEquals(sortedStudents, expectedStudents);
	}

	@Test
	public void testComparatorWithSameMarks() {
		Student s1 = new Student(1, "a", 6);
		s1.getStudentMarks().put(Subject.BIOLOGY, new Mark(1, Subject.BIOLOGY, 5));
		s1.getStudentMarks().put(Subject.CHEMISTRY, new Mark(1, Subject.CHEMISTRY, 5));
		s1.getStudentMarks().put(Subject.MATHS, new Mark(1, Subject.MATHS, 5));
		s1.getStudentMarks().put(Subject.PHYSICS, new Mark(1, Subject.PHYSICS, 5));
		s1.getStudentMarks().put(Subject.GEOGRAPHY, new Mark(1, Subject.GEOGRAPHY, 5));

		Student s2 = new Student(2, "b", 5);
		s2.getStudentMarks().put(Subject.BIOLOGY, new Mark(2, Subject.BIOLOGY, 5));
		s2.getStudentMarks().put(Subject.CHEMISTRY, new Mark(2, Subject.CHEMISTRY, 5));
		s2.getStudentMarks().put(Subject.MATHS, new Mark(2, Subject.MATHS, 5));
		s2.getStudentMarks().put(Subject.PHYSICS, new Mark(2, Subject.PHYSICS, 5));
		s2.getStudentMarks().put(Subject.GEOGRAPHY, new Mark(2, Subject.GEOGRAPHY, 5));

		List<Student> sortedStudents = new ArrayList<Student>();
		sortedStudents.add(s1);
		sortedStudents.add(s2);

		List<Student> expectedStudents = new ArrayList<Student>();
		expectedStudents.add(s2);
		expectedStudents.add(s1);

		Collections.sort(sortedStudents, StudentDao.StudentRankComparator);
		assertEquals(sortedStudents, expectedStudents);
	}

	@Test
	public void testRankedWrite() throws IOException {
		StudentDao studentDao = new StudentDao();
		Map<Integer, Student> students = studentDao.loadStudents(STUDENT_CSV_FILE_PATH);
		studentDao.loadMarks(students, MARK_CSV_FILE_PATH);
		studentDao.storeStudent(new ArrayList<Student>(students.values()), OUTPUT_CSV_FILE_PATH);

		List<Student> sortedStudents = new ArrayList<Student>(students.values());
		Collections.sort(sortedStudents, StudentDao.StudentRankComparator);

		List<Student> writtenStudents = new ArrayList<Student>();
		CSVReader csvReader = new CSVReader(new FileReader(OUTPUT_CSV_FILE_PATH));
		List<String[]> rows = csvReader.readAll();
		for (String[] row : rows) {
			Integer studentId = Integer.valueOf(row[1]);
			String studentName = row[2];
			Integer studentAge = Integer.valueOf(row[3]);
			writtenStudents.add(new Student(studentId, studentName, studentAge));
		}
		assertEquals(sortedStudents, writtenStudents);

	}
}
