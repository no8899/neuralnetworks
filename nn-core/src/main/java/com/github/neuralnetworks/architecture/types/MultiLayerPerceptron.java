package com.github.neuralnetworks.architecture.types;

import com.github.neuralnetworks.architecture.FullyConnected;
import com.github.neuralnetworks.architecture.Layer;
import com.github.neuralnetworks.architecture.NeuralNetwork;
import com.github.neuralnetworks.architecture.OneToOne;
import com.github.neuralnetworks.calculation.neuronfunctions.ConstantConnectionCalculator;

/**
 * a Multi Layer perceptron network
 * 
 */
public class MultiLayerPerceptron extends NeuralNetwork {
    public void addLayer(Layer layer, boolean addBias) {
	if (getLayers().size() > 0) {
	    addConnection(new FullyConnected(getOutputLayer(), layer));
	} else {
	    getLayers().add(layer);
	}

	if (addBias) {
	    addConnection(new OneToOne(new Layer(layer.getNeuronCount(), new ConstantConnectionCalculator(1)), layer));
	}
    }
}
