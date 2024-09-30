import 'dart:developer';

import 'package:flutter/material.dart';

class AddOneWidget extends StatefulWidget {
  const AddOneWidget({super.key});

  @override
  State<AddOneWidget> createState() => _AddOneWidgetState();
}

class _AddOneWidgetState extends State<AddOneWidget> {
  int _counter = 0;

  @override
  void initState() {
    log('initState');
    super.initState();
    _counter = 0;
  }

  @override
  void dispose() {
    log('dispose');
    super.dispose();
  }

  @override
  void didChangeDependencies() {
    log('didChangeDependencies');
    super.didChangeDependencies();
  }

  @override
  void didUpdateWidget(covariant AddOneWidget oldWidget) {
    super.didUpdateWidget(oldWidget);
  }

  @override
  void activate() {
    log('activate');
    super.activate();
  }

  @override
  void deactivate() {
    log('deactivate');
    super.deactivate();
  }

  @override
  void reassemble() {
    log('reassemble');
    super.reassemble();
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(_counter.toString()),
        const SizedBox(
          height: 20,
        ),
        OutlinedButton(
          onPressed: () {
            setState(() {
              _counter++;
            });
          },
          child: const Text("Add"),
        ),
        const SizedBox(
          height: 20,
        ),
        OutlinedButton(
          onPressed: () {
            setState(() {
              _counter = 0;
            });
          },
          child: const Text("Clear"),
        )
      ],
    );
  }
}
