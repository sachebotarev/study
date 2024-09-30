import 'dart:developer';

import 'package:flutter/material.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Container(
          color: Colors.green,
          child: Center(
              child: CustomSingleChildLayout(
            delegate: MySingleChildLayoutDelegate(),
            child: Container(
              height: 100,
              width: 100,
              color: Colors.red,
              child: const Text("Hello"),
            ),
          )),
        ),
      ),
    );
  }
}

class MySingleChildLayoutDelegate extends SingleChildLayoutDelegate {
  @override
  bool shouldRelayout(covariant SingleChildLayoutDelegate oldDelegate) {
    log('shouldRelayout');
    return false;
  }

  @override
  Size getSize(BoxConstraints constraints) {
    log('getSize $constraints');
    return const Size(200, 200);
  }

  @override
  BoxConstraints getConstraintsForChild(BoxConstraints constraints) {
    log('getConstraintsForChild $constraints');
    return BoxConstraints.loose(Size(50, 50));
  }

  @override
  Offset getPositionForChild(Size size, Size childSize) {
    log('getPositionForChild $size $childSize');
    return Offset(
      size.width / 2 - childSize.width / 2,
      size.height / 2 - childSize.height / 2,
    );
  }
}
