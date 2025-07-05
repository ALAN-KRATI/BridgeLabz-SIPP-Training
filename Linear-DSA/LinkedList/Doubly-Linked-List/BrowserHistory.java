class Page {
    String url;
    Page next, prev;

    public Page(String url) {
        this.url = url;
        this.next = this.prev = null;
    }
}

public class BrowserHistory {
    Page current;

    public void visit(String url) {
        Page newPage = new Page(url);
        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }
        current = newPage;
        System.out.println("Visited: " + url);
    }

    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No forward page.");
        }
    }

    public void currentPage() {
        if (current != null) {
            System.out.println("Current: " + current.url);
        } else {
            System.out.println("No page visited.");
        }
    }

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory();
        bh.visit("google.com");
        bh.visit("openai.com");
        bh.visit("github.com");
        bh.back();
        bh.currentPage();
        bh.forward();
        bh.currentPage();
    }
}
