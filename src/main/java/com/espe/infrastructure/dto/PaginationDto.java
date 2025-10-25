package com.espe.infrastructure.dto;

import java.util.List;

public class PaginationDto <T> {
    private List<T> content;
    private Integer currentPage;
    private Integer sizePage;
    private Integer totalPages;
    private Integer totalElements;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getSizePage() {
        return sizePage;
    }

    public void setSizePage(Integer sizePage) {
        this.sizePage = sizePage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public PaginationDto(List<T> content, Integer currentPage, Integer sizePage, Integer totalPages, Integer totalElements) {
        this.content = content;
        this.currentPage = currentPage;
        this.sizePage = sizePage;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
}
