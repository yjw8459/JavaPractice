package vo;

public class ChildProduct<T, M, C> {
    private C company;

    public void setCompany(C company) { this.company = company; }

    public C getCompany() { return company; }
}
