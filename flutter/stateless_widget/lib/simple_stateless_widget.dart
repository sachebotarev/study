import 'dart:developer';

import 'package:flutter/material.dart';

class SimpleStatelessWidget extends StatelessWidget {
  const SimpleStatelessWidget({super.key});

  @override
  Widget build(BuildContext context) {
    log('SimpleStatelessWidget build() run');
    return const Center(
      child: Text('Hello World!'),
    );
  }
}
