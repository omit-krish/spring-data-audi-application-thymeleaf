package com.omitkrish.thymleaf.pageable;

public class StudentPageable {


    private int pageSize;

    private long totalStudents;

    private int totalPages;

    private int currentPage;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "StudentPageable{" +
                "pageSize=" + pageSize +
                ", totalStudents=" + totalStudents +
                ", totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                '}';
    }
}
