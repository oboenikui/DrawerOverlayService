package com.google.android.libraries.gsa.d.a;

import android.os.Build;
import android.util.Log;
import android.view.WindowManager.LayoutParams;

final class TransparentOverlayController implements t {

    public final /* synthetic */ OverlayController overlayController;

    TransparentOverlayController(OverlayController overlayControllerVar) {
        this.overlayController = overlayControllerVar;
    }

    public final void cnE() {
        Log.d("wo.OverlayController", "Drag event called in transparent mode");
    }

    public final void cnF() {
    }

    public final void oc(boolean z) {
    }

    public final void cnG() {
        this.overlayController.ob(true);
        OverlayController overlayControllerVar = this.overlayController;
        LayoutParams attributes = overlayControllerVar.window.getAttributes();
        if (Build.VERSION.SDK_INT >= 26) {
            float f = attributes.alpha;
            attributes.alpha = 1.0f;
            if (f != attributes.alpha) {
                overlayControllerVar.window.setAttributes(attributes);
            }
        } else {
            attributes.x = 0;
            attributes.flags &= -513;
            overlayControllerVar.unZ = true;
            overlayControllerVar.window.setAttributes(attributes);
        }
        overlayControllerVar = this.overlayController;
        PanelState panelStateVar = PanelState.OPEN_AS_LAYER;//Todo: PanelState.uoh was default
        if (overlayControllerVar.panelState != panelStateVar) {
            overlayControllerVar.panelState = panelStateVar;
            overlayControllerVar.a(overlayControllerVar.panelState);
        }
    }

    public final void cnH() {
        OverlayController overlayControllerVar = this.overlayController;
        LayoutParams attributes = overlayControllerVar.window.getAttributes();
        if (Build.VERSION.SDK_INT >= 26) {
            float f = attributes.alpha;
            attributes.alpha = 0.0f;
            if (f != attributes.alpha) {
                overlayControllerVar.window.setAttributes(attributes);
            }
        } else {
            attributes.x = overlayControllerVar.unO;
            attributes.flags |= 512;
            overlayControllerVar.unZ = false;
            overlayControllerVar.window.setAttributes(attributes);
        }
        this.overlayController.ob(false);
        overlayControllerVar = this.overlayController;
        PanelState panelStateVar = PanelState.CLOSED;//Todo: PanelState.uoe was default
        if (overlayControllerVar.panelState != panelStateVar) {
            overlayControllerVar.panelState = panelStateVar;
            overlayControllerVar.a(overlayControllerVar.panelState);
        }
        this.overlayController.slidingPanelLayout.uoH = this.overlayController.unV;
    }

    public final void D(float f) {
    }

    public final boolean cnI() {
        return true;
    }
}