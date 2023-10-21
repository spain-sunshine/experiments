// Author 类，代表书的作者
class Author {
    private String name;
    private String bio;

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public String toString() {
        return "Author: " + name + "\nBio: " + bio;
    }
}

// Book 类，代表一本书
class Book {
    private String title;
    private Author author;  // 这里的组合发生：Book 类有一个 Author 对象作为属性

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" + author.toString();
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Author author = new Author("George Orwell", "English novelist, essayist, journalist and critic.");
        Book book = new Book("1984", author);

        System.out.println(book);
    }
}
