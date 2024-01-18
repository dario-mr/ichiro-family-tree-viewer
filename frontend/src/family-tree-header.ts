import { html, LitElement } from 'lit';

class FamilyTreeHeader extends LitElement {
  render() {
    return html`
        <h2 style="margin: 0.2em 0;">Ichiro Family Tree</h2>

        <vaadin-horizontal-layout theme="spacing" style="align-items: end">
            <vaadin-integer-field
                id="generations"
                label="Generations"
                value="5"
                min="2"
                max="6"
                step-buttons-visible
                ></vaadin-integer-field>
            <vaadin-button id="expand">Expand All</vaadin-button>
            <vaadin-button id="collapse">Collapse All</vaadin-button>
        </vaadin-horizontal-layout>
    `;
  }
}

customElements.define('family-tree-header', FamilyTreeHeader);