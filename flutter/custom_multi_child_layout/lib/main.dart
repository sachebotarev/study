import 'dart:math';

import 'package:flutter/material.dart';

// Компоновка виджетов по спирали Архимеда
void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  static final List<int> val = [for (var i = 1; i <= 20; i++) i];
  final double base = 5;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: CustomMultiChildLayout(
            delegate: MyMultiChildLayoutDelegate(),
            children: val
                .map((x) => LayoutId(
                      id: x,
                      child: Circle(
                          radius: base * x, color: Colors.red.withBlue(x * 30)),
                    ))
                .toList(),
          ),
        ),
      ),
    );
  }
}

class Circle extends StatelessWidget {
  final double radius;
  final Color color;
  const Circle({super.key, required this.radius, required this.color});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: radius * 2,
      height: radius * 2,
      decoration: BoxDecoration(shape: BoxShape.circle, color: color),
      //color: Colors.red,
      child: Center(
          child: Text(
        radius.toString(),
        style: TextStyle(color: Colors.white, fontSize: radius),
      )),
    );
  }
}

class MyMultiChildLayoutDelegate extends MultiChildLayoutDelegate {
  // Располагаем дочерние объекты
  @override
  void performLayout(Size size) {
    // Центр спирали
    var center = Offset(size.width / 2, size.height / 2);
    for (final item in MainApp.val) {
      if (!hasChild(item)) return;
      // 1. Устанавливаем ограничения дочерним объектам в ответ получаем их реальные размеры
      final childSize = layoutChild(item, BoxConstraints.loose(size));
      final r = //childSize.width / 3;
          sqrt(pow(childSize.width / 2, 2) + pow(childSize.height / 2, 2));
      //
      final pos = center -
          // Смещаем центр окружности на радиус окружности, что цент попадал на линию спирали
          Offset(childSize.width / 2, childSize.height / 2) -
          // Линия спирали
          Offset(3 * r * cos(r), 3 * r * sin(r));
      // 2.  Располагаем объекты
      positionChild(item, pos);
    }
  }

  // Вызывается при смене делегата. Определяем должна ли быть произведена рекомпоновка
  @override
  bool shouldRelayout(covariant MultiChildLayoutDelegate oldDelegate) {
    return true;
  }
}
