package BasicJava;


class library
{
    int number_of_book=0;
    int issueBookNumber=0;
    String [] books = new String[100];
    String [] issueBook = new String[100];

    void addBook (String b)
    {
        this.books[number_of_book]=b;
        number_of_book++;
        System.out.println("\""+b+"\""+ "Book is add!");
    }
    void  showBook ()
    {
        System.out.println("available Book are:");
        for (String b:this.books)
        {
            if (b==null)
            {
                continue;
            }
            System.out.println("* "+b);
        }

    }
    void  issueBook (String book)
    {
        for (int i=0;i<this.books.length;i++)
        {
            if (this.books[i].equals(book))
            {
                issueBook[issueBookNumber]=book;
                this.books[i]=null;
                issueBookNumber++;
                return;
            }
        }
        System.out.println("sorry,This book is not availableBooks");
    }
    void returnBook(String book)
    {
        for (int i=0;i<number_of_book;i++)
        {
            if (this.issueBook[i]==book)
            {
                issueBook[i]=null;
            }
            if (this.books[i]==null)
            {
                this.books[i]=book;
                return;
            }

        }
        System.out.println("this book is not over book");
    }
    void showIssueBook()
    {
        for (String b:this.issueBook)
        {
            if (issueBook==null)
            {
                continue;
            }
            System.out.println("* "+b);
        }
    }

}
public class Ex_4 {
    public static void main(String[] args) {

        library newlibrary = new library();
        newlibrary.addBook("think and grow rich");
        newlibrary.addBook("DSA");
        newlibrary.addBook("JAVA");
        newlibrary.showBook();
        newlibrary.issueBook("JAVA");
        newlibrary.showBook();
        newlibrary.returnBook("JAVA");
        newlibrary.showBook();

    }
}
