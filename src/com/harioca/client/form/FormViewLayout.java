package com.harioca.client.form;

import com.google.gwt.user.client.ui.RootPanel;
import com.harioca.client.TestData___DeleteMe;
import com.harioca.client.bean.hbase.row.HRow;
import com.harioca.client.form.widget.HeaderButton;
import com.harioca.client.smartgwt.ChangePanel;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

public class FormViewLayout extends VLayout {


    private PagerLayout pagerLayout = new PagerLayout();;

    private int nextPageNumber = 0;

    private PageLayout previousPage;
    private PageLayout currentPage;
    private PageLayout nextPage;

    private ChangePanel changePanel = new ChangePanel();

    public FormViewLayout() {
        setStyleName("harioca-formPanel");
        setMembersMargin(5);

        addViewFormHeader();

        addMember(pagerLayout);

        currentPage = getNextRowLayout(nextPageNumber++);
        nextPage = getNextRowLayout(nextPageNumber++);
        nextPage.setLeft(RootPanel.get().getOffsetWidth() - 70);

        addLeftMover();
        addRightMover();
    }

    private void addViewFormHeader() {
        HLayout formViewHeader = new HLayout();
        formViewHeader.setStyleName("harioca-formViewHeader");
        formViewHeader.setHeight(25);
        formViewHeader.addMember(getFloatingModeButton());
        addMember(formViewHeader);
    }

    private void addRightMover() {
        Layout rightMover = getRightMover();
        rightMover.setLeft(RootPanel.get().getOffsetWidth() - 70);
        rightMover.setHeight(RootPanel.get().getOffsetHeight() - 30);
        addChild(rightMover);
    }

    private void addLeftMover() {
        Layout leftMover = getLeftMover();
        leftMover.setHeight(RootPanel.get().getOffsetHeight() - 30);
        addChild(leftMover);
    }

    public Layout getLeftMover() {
        final Layout leftMover = new Layout();
        leftMover.setWidth(100);
        leftMover.setTop(30);

        leftMover.setCanDrag(true);
        leftMover.setDragAppearance(DragAppearance.TARGET);
        leftMover.addDragMoveHandler(new DragMoveHandler() {
            @Override
            public void onDragMove(DragMoveEvent event) {
                if (leftMover.getLeft() != 0) {
                    currentPage.moveTo(leftMover.getLeft(), 0);
                }
            }
        });
        leftMover.addDragStopHandler(new DragStopHandler() {
            @Override
            public void onDragStop(DragStopEvent event) {
                leftMover.moveTo(currentPage.getLeft(), 30);
            }
        });
        leftMover.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                turnPageBack();
                if (leftMover.getLeft() != 0) {
                    leftMover.moveTo(0, 30);
                }
            }
        });

        return leftMover;
    }

    public Layout getRightMover() {
        final Layout rightMover = new Layout();
        rightMover.setWidth(100);
        rightMover.setTop(30);

        rightMover.setCanDrag(true);
        rightMover.setDragAppearance(DragAppearance.TARGET);
        rightMover.addDragMoveHandler(new DragMoveHandler() {
            @Override
            public void onDragMove(DragMoveEvent event) {
                if (rightMover.getLeft() != 0) {
                    nextPage.moveTo(rightMover.getLeft(), 0);
                }
            }
        });
        rightMover.addDragStopHandler(new DragStopHandler() {
            @Override
            public void onDragStop(DragStopEvent event) {
                rightMover.moveTo(nextPage.getLeft(), 30);
            }
        });
        rightMover.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                turnPage();
                if (rightMover.getLeft() != RootPanel.get().getOffsetWidth() - 70) {
                    rightMover.moveTo(RootPanel.get().getOffsetWidth() - 70, 30);
                }
            }
        });

        return rightMover;
    }

    public void turnPage() {
        long start = System.currentTimeMillis();

        nextPage.moveTo(0, 0); // todo animateMove?
        if (previousPage != null) {
            previousPage.destroy();
        }
        previousPage = currentPage;
        currentPage = nextPage;

        PageLayout pageLayout = getNextRowLayout(nextPageNumber++);
        pageLayout.setLeft(RootPanel.get().getOffsetWidth() - 70);
        nextPage = pageLayout;

        System.out.println("addRowLayout " + (System.currentTimeMillis() - start));
    }

    public void turnPageBack() {
        long start = System.currentTimeMillis();

        if (nextPage != null) {
            nextPage.destroy();
        }
        currentPage.moveTo(RootPanel.get().getOffsetWidth() - 70, 0); // todo animateMove?
        nextPage = currentPage;
        currentPage = previousPage;

        previousPage = getNextRowLayout(--nextPageNumber-3);
        previousPage.sendToBack();

        System.out.println("addRowLayout " + (System.currentTimeMillis() - start));
    }

    public PageLayout getNextRowLayout(int pageNum) {
        HRow hRow = TestData___DeleteMe.getTestHRow(pageNum);
        PageLayout pageLayout = pagerLayout.addPageLayout(hRow);
        pageLayout.getLeftArrow().setHeight(RootPanel.get().getOffsetHeight() - 30);

        return pageLayout;
    }

    public HeaderButton getFloatingModeButton() {
        final HeaderButton floatingModeButton = new HeaderButton("Floating Mode", "Ctrl+Alt+F");
        floatingModeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                currentPage.getRowFormLayout().makeFloating(!currentPage.getRowFormLayout().isInFloatingMode());
                if (currentPage.getRowFormLayout().isInFloatingMode()) {
                    changePanel.show();
                } else {
                    changePanel.hide();
                }

                floatingModeButton.switchPressed();
            }
        });

        return floatingModeButton;
    }
}
