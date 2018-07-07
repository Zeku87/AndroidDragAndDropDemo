# Drag and drop demo application for Android

## Description
In this demo we have three text views and three image views. Each text view is a color and the user has to drag those text views to the corresponding image view color.

## Things to take into account when using the drag and drop API
- Register an `OnTouchListener` on the text views wich are going to be dragged.
- Register an `onDragListener` on the image views on wich the text views are going to drop.
- Remember that `onDrag` method must return **true** in order to become active.
