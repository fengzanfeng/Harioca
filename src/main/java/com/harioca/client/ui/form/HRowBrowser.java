package com.harioca.client.ui.form;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.harioca.client.HariocaEntryPoint;
import com.harioca.client.HariocaShellService;
import com.harioca.client.bean.hbase.HPageDefinition;
import com.harioca.client.bean.hbase.HRow;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;

public class HRowBrowser extends HLayout {

    public static int CURRENT_ROW_ID = 0;

    private final Layout leftDrag = new Layout();

    public HRowBrowser() {
        setWidth(2 * HariocaEntryPoint.WIDTH_100);

        addChild(HRowBuilder.getHRowPage(0));
        addChild(HRowBuilder.getHRowPage(1));
        addChild(HRowBuilder.getHRowPage(2));
        HRowBuilder.getHRowPage(2).setLeft(HariocaEntryPoint.WIDTH_100);

        addChild(createLeftDrag());
        addChild(createRigthDrag());
    }

    public static void init() {
        HariocaShellService.App.getInstance().getHPageDefinition(new AsyncCallback<HPageDefinition>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(HPageDefinition hPageDefinition) {
                HRowBuilder.init(hPageDefinition);
            }
        });
    }

    public void loadRow(final int hRowPanelN, final int hRowN) {
        HariocaShellService.App.getInstance().getHRow(hRowN, new AsyncCallback<HRow>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(HRow hRow) {
                HRowBuilder.updateHRowPage(hRowPanelN, hRow);
            }
        });
    }

    private Layout createLeftDrag() {
        leftDrag.setWidth("3%");
        leftDrag.setHeight(500);
        leftDrag.setCanDrag(true);
        leftDrag.setDragAppearance(DragAppearance.TARGET);
        leftDrag.setNoDoubleClicks(true);

        leftDrag.addDragMoveHandler(new DragMoveHandler() {
            @Override
            public void onDragMove(DragMoveEvent event) {
                if (leftDrag.getLeft() != 0) {
                    HRowBuilder.getHRowPage(1).moveTo(leftDrag.getLeft(), 0);
                }
            }
        });
        leftDrag.addDragStopHandler(new DragStopHandler() {
            @Override
            public void onDragStop(DragStopEvent event) {
                leftDrag.moveTo(HRowBuilder.getHRowPage(1).getLeft(), 0);
            }
        });
        leftDrag.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (CURRENT_ROW_ID > 0) {
                    turnPage(false);
                    leftDrag.moveTo(HRowBuilder.getHRowPage(1).getLeft(), 0);
                    loadRow(0, CURRENT_ROW_ID - 1);
                    if (CURRENT_ROW_ID == 0) {
                        leftDrag.setCanDrag(false);
                        leftDrag.setBackgroundColor("#ffffff");
                    }
                }
            }
        });

        return leftDrag;
    }

    private Layout createRigthDrag() {
        final Layout rightDrag = new Layout();
        rightDrag.setLeft(HariocaEntryPoint.WIDTH_100);
        rightDrag.setWidth("3%");
        rightDrag.setHeight(500);
        rightDrag.setCanDrag(true);
        rightDrag.setDragAppearance(DragAppearance.TARGET);
        rightDrag.setNoDoubleClicks(true);

        rightDrag.addDragMoveHandler(new DragMoveHandler() {
            @Override
            public void onDragMove(DragMoveEvent event) {
                if (rightDrag.getLeft() != 0) {
                    HRowBuilder.getHRowPage(2).moveTo(rightDrag.getLeft(), 0);
                }
            }
        });
        rightDrag.addDragStopHandler(new DragStopHandler() {
            @Override
            public void onDragStop(DragStopEvent event) {
                rightDrag.moveTo(HRowBuilder.getHRowPage(2).getLeft(), 0);
            }
        });
        rightDrag.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                turnPage(true);
                rightDrag.moveTo(HRowBuilder.getHRowPage(2).getLeft(), 0);
                loadRow(2, CURRENT_ROW_ID + 1);
                if (CURRENT_ROW_ID > 0 && !leftDrag.getCanDrag()) {
                    leftDrag.setCanDrag(true);
                    leftDrag.setBackgroundColor(null);
                }
            }
        });

        return rightDrag;
    }

    private void turnPage(boolean forward) {
        if (forward) {
            HRowBuilder.getHRowPage(2).moveTo(0, 0);                     //todo animate?
            HRowBuilder.getHRowPage(0).moveTo(HariocaEntryPoint.WIDTH_100, 0);
            HRowBuilder.getHRowPage(2).sendToBack();
            HRowBuilder.getHRowPage(1).sendToBack();
            CURRENT_ROW_ID++;
        } else {
            HRowBuilder.getHRowPage(1).moveTo(HariocaEntryPoint.WIDTH_100, 0); //todo animate?
            HRowBuilder.getHRowPage(2).sendToBack();
            HRowBuilder.getHRowPage(2).moveTo(0, 0);
            CURRENT_ROW_ID--;
        }
        HRowBuilder.shiftPages(forward);
    }
}
