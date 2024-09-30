import 'dart:developer';

import 'package:flutter/material.dart';

class PropertyStatelessWidget extends StatelessWidget {
  final int value;
  const PropertyStatelessWidget({super.key, required this.value});

  @override
  Widget build(BuildContext context) {
    log('PropertyStatelessWidget build() run with $value');
    return Center(
      child: Text('Current value $value'),
    );
  }
}

class NoChangedStatelessWidget extends StatelessWidget {
  const NoChangedStatelessWidget({super.key});

  @override
  Widget build(BuildContext context) {
    log('NoChangedStatelessWidget build() run');
    return const Center(child: Text('Hello'));
  }
}
