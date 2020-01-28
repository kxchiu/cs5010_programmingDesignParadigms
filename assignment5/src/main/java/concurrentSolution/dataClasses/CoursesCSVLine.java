package concurrentSolution.dataClasses;

public class CoursesCSVLine extends AbstractCSVLine {

  transient private String codeModule;
  transient private String codePresentation;
  transient private Integer codePresentationLength;

  public CoursesCSVLine() {
    this.codeModule = null;
    this.codePresentation = null;
    this.codePresentationLength = null;
  }

  public void setCodePresentationLength(String codePresentationLength) {
    this.codePresentationLength = new Integer(codePresentationLength);
  }

  public void setCodeModule(String codeModule) {
    this.codeModule = codeModule;
  }

  public void setCodePresentation(String codePresentation) {
    this.codePresentation = codePresentation;
  }

  public void setCodePresentationLength(Integer codePresentationLength) {
    this.codePresentationLength = codePresentationLength;
  }

  @Override
  public String toString() {
    return "CoursesCSVLine{" +
        "codeModule='" + codeModule + '\'' +
        ", codePresentation='" + codePresentation + '\'' +
        ", codePresentationLength=" + codePresentationLength +
        '}';
  }

  public Integer getCodePresentationLength() {
    return codePresentationLength;
  }

}
