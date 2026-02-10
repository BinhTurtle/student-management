-- Tạo bảng sinh viên (giô ́ng câ ́u trúc Entity Lab 2)
CREATE TABLE IF NOT EXISTS students (
	id INTEGER PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	age INTEGER NOT NULL
);
-- Thêm dữ liệu mau
INSERT INTO students (id, name, email, age) VALUES 
	(1, 'Nguyen Van A', 'vana@example.com', 20),
	(2, 'Tran Thi B', 'thib@example.com', 21),
	(3, 'Doan Van C', 'vanc@example.com', 18),
	(4, 'Hoang Van D', 'vand@example.com', 19),
	(5, 'Nguyen Thi E', 'thiE@example.com', 22),
	(6, 'Bui Van F', 'vanf@example.com', 20),
	(7, 'Doan Thi G', 'thig@example.com', 20),
	(8, 'Bui Thi H', 'thih@example.com', 21),
	(9, 'Cao Van I', 'vani@example.com', 18),
	(10, 'Nguyen Quang J', 'quangj@example.com', 19),
	(11, 'Dinh Cong K', 'congk@example.com', 18),
	(12, 'Tran Thao L', 'thaol@example.com', 19);