package concurrentSolution.dataClasses;

public class StudentVleLine extends AbstractCSVLine {

  transient private String codeModule;
  transient private String codePresentation;
  transient private Integer idStudent;
  transient private Integer idSite;
  transient private Integer date;
  transient private Integer sumClick;

  public StudentVleLine() {
    this.codeModule = null;
    this.codePresentation = null;
    this.idStudent = null;
    this.idSite = null;
    this.date = null;
    this.sumClick = null;
  }

  public Integer getIdStudent() {
    return idStudent;
  }

  public Integer getIdSite() {
    return idSite;
  }

  public Integer getDate() {
    return date;
  }

  public Integer getSumClick() {
    return sumClick;
  }

  public String getCodeModule() {
    return codeModule;
  }

  public String getCodePresentation() {
    return codePresentation;
  }

  public void setIdStudent(String idStudent) {
    this.idStudent = new Integer(idStudent);
  }

  public void setIdSite(String idSite) {
    this.idSite = new Integer(idSite);
  }

  public void setDate(String date) {
    this.date = new Integer(date);
  }

  public void setSumClick(String sumClick) {
    this.sumClick = new Integer(sumClick);
  }

  public void setCodeModule(String codeModule) {
    this.codeModule = codeModule;
  }

  public void setCodePresentation(String codePresentation) {
    this.codePresentation = codePresentation;
  }

  @Override
  public String toString() {
    return "StudentVleLine{" +
        "idStudent=" + idStudent +
        ", idSite=" + idSite +
        ", date=" + date +
        ", sumClick=" + sumClick +
        '}';
  }
}
