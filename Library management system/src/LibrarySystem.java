import java.util.Scanner;

class Book {
    String title;
    String author;
    int bookID;

    Book(String title, int bookID, String author) {
        this.title = title;
        this.bookID = bookID;
        this.author = author;
    }
}

class Borrow {
    int bookID;
    String studentID;
    String borrowDate;

    Borrow(int bookID, String studentID, String borrowDate) {
        this.bookID = bookID;
        this.studentID = studentID;
        this.borrowDate = borrowDate;
    }
}

public class LibrarySystem {

    static Book[] books = new Book[100];
    static int bookCount = 0;

    static Borrow[] borrows = new Borrow[100];
    static int borrowCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== قائمة الخيارات =====");
            System.out.println("1. إدخال بيانات كتاب جديد");
            System.out.println("2. البحث عن كتاب بواسطة الاسم");
            System.out.println("3. طباعة استمارة استعارة كتاب");
            System.out.println("4. عرض جميع الكتب في المكتبة");
            System.out.println("5. خروج");
            System.out.print("أدخل خيارك: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    searchBook(scanner);
                    break;
                case 3:
                    borrowBook(scanner);
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("تم الخروج من النظام. شكرًا لاستخدامك البرنامج.");
                    break;
                default:
                    System.out.println("⚠️ خيار غير صحيح! الرجاء إدخال رقم من 1 إلى 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // 1. إضافة كتاب
    public static void addBook(Scanner scanner) {
        System.out.print("أدخل اسم الكتاب: ");
        String title = scanner.nextLine();
        System.out.print("أدخل رقم الكتاب: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("أدخل اسم المؤلف: ");
        String author = scanner.nextLine();

        books[bookCount++] = new Book(title, id, author);
        System.out.println("✅ تم إضافة الكتاب بنجاح.");
    }

    // 2. البحث عن كتاب
    public static void searchBook(Scanner scanner) {
        System.out.print("أدخل اسم الكتاب للبحث: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equalsIgnoreCase(searchTitle)) {
                System.out.println("📚 تم العثور على الكتاب:");
                System.out.println("الاسم: " + books[i].title);
                System.out.println("رقم الكتاب: " + books[i].bookID);
                System.out.println("المؤلف: " + books[i].author);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ لم يتم العثور على الكتاب.");
        }
    }

    // 3. طباعة استمارة استعارة
    public static void borrowBook(Scanner scanner) {
        System.out.print("أدخل رقم الكتاب: ");
        int bookID = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("أدخل الرقم الأكاديمي للطالب: ");
        String studentID = scanner.nextLine();
        System.out.print("أدخل تاريخ الاستعارة (مثلاً 2025-06-21): ");
        String date = scanner.nextLine();

        borrows[borrowCount++] = new Borrow(bookID, studentID, date);
        System.out.println("✅ تم تسجيل الاستعارة بنجاح.");
    }

    // 4. عرض جميع الكتب
    public static void displayBooks() {
        if (bookCount == 0) {
            System.out.println("📂 لا توجد كتب في المكتبة حاليًا.");
            return;
        }

        System.out.println("\n📚 قائمة الكتب في المكتبة:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("--------------");
            System.out.println("اسم الكتاب: " + books[i].title);
            System.out.println("رقم الكتاب: " + books[i].bookID);
            System.out.println("المؤلف: " + books[i].author);
        }
    }
}