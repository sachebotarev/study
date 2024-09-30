import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:stateless_widget/inherit_stateless_widget.dart';
import 'package:stateless_widget/property_stateless_widget.dart';
import 'package:stateless_widget/simple_stateless_widget.dart';

void main() {
  runApp(const MainApp());
}

// Методы  build() вызывается в следующих случаях
class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const PropertyMainScreen();
  }
}

// 1. виджет в первый раза добавляется в дерево виджетов
class SimpleMainScreen extends StatelessWidget {
  const SimpleMainScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: Scaffold(body: SimpleStatelessWidget()),
    );
  }
}

//  2. когда родительский видждет меняет свою конфигурацию
class PropertyMainScreen extends StatefulWidget {
  const PropertyMainScreen({super.key});

  @override
  State<PropertyMainScreen> createState() => _PropertyMainScreenState();
}

class _PropertyMainScreenState extends State<PropertyMainScreen> {
  int _counter = 0;

  @override
  Widget build(BuildContext context) {
    log('PropertyMainScreen build() run');
    return MaterialApp(
      home: Scaffold(
        floatingActionButton: FloatingActionButton(
          onPressed: _incrementCount,
          child: const Icon(Icons.add),
        ),
        body: Column(
          children: [
            methodWidget(), // Не вызывает повторной перерисовки
            const NoChangedStatelessWidget(), // Если убрать const виджет будет перерисовываться
            PropertyStatelessWidget(
              value: _counter,
            ),
          ],
        ),
      ),
    );
  }

  void _incrementCount() {
    setState(() {
      _counter++;
    });
  }

  Widget methodWidget() {
    log('methodWidget() run');
    return const Center(child: NoChangedStatelessWidget());
  }
}

// 3. когда меняется объект InheritedWidget от которого зависит виджет
class InheritMainScreen extends StatelessWidget {
  const InheritMainScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: Scaffold(body: InheritStatelessWidget()),
    );
  }
}
